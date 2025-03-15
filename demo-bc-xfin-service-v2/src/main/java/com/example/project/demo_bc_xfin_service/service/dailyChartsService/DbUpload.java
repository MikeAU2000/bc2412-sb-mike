package com.example.project.demo_bc_xfin_service.service.dailyChartsService;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import com.example.project.demo_bc_xfin_service.repository.TstocksPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.demo_bc_xfin_service.config.AppConfig;
import com.example.project.demo_bc_xfin_service.dto.YahooFinanceChartDto;
import com.example.project.demo_bc_xfin_service.entity.TstocksPriceOhlcvEntity;
import com.example.project.demo_bc_xfin_service.manager.yfManager.CrubManager;
import com.example.project.demo_bc_xfin_service.manager.yfManager.YahooFinanceManager;
import com.example.project.demo_bc_xfin_service.manager.yfManager.YahooService;
import com.example.project.demo_bc_xfin_service.repository.TstocksPriceOhlcvRepository;

@Service
public class DbUpload {
  @Autowired
  private YahooService yahooService;

  @Autowired
  private CrubManager crubManager;

  @Autowired
  private YahooFinanceManager yahooFinanceManager;

  @Autowired
  private TstocksPriceOhlcvRepository tstocksPriceOhlcvRepository;




  public YahooFinanceChartDto getYahooData(String symbol) {
    String cookies = yahooService.getYahooCookies();
    String key = crubManager.getKey(cookies);
    YahooFinanceChartDto yahooFinanceChartDto =
        yahooFinanceManager.getStockChartDTO(symbol, key, cookies);
    return yahooFinanceChartDto;
  }

  public void saveStockDataFromDTO(String symbol) {
    YahooFinanceChartDto yahooFinanceChartDto = getYahooData(symbol);

    if (yahooFinanceChartDto == null || yahooFinanceChartDto.getChart() == null
        || yahooFinanceChartDto.getChart().getResult() == null
        || yahooFinanceChartDto.getChart().getResult().isEmpty()) {
      throw new IllegalArgumentException(
          "StockChartDTO is null or empty for symbol: " + symbol);
    }

    YahooFinanceChartDto.Result result =
        yahooFinanceChartDto.getChart().getResult().get(0);

    if (result.getMeta() == null || result.getIndicators() == null
        || result.getIndicators().getQuote() == null
        || result.getIndicators().getQuote().isEmpty()) {
      throw new IllegalArgumentException(
          "Missing essential data in DTO for symbol: " + symbol);
    }

    YahooFinanceChartDto.Meta meta = result.getMeta();
    YahooFinanceChartDto.Quote quote = result.getIndicators().getQuote().get(0);
    List<Long> timestamps = result.getTimestamp();

    if (timestamps == null || timestamps.isEmpty() || quote.getOpen() == null
        || quote.getHigh() == null || quote.getLow() == null
        || quote.getClose() == null || quote.getVolume() == null) {
      throw new IllegalArgumentException(
          "Timestamp or OHLCV data is missing for symbol: " + symbol);
    }

    for (int i = 0; i < timestamps.size(); i++) {
      LocalDate tradeDate = Instant.ofEpochSecond(timestamps.get(i))
          .atZone(ZoneId.systemDefault()).toLocalDate();

      TstocksPriceOhlcvEntity entity = TstocksPriceOhlcvEntity.builder()
          .tradeDate(tradeDate).symbol(meta.getSymbol()).validRange("1d")
          .open(i < quote.getOpen().size() ? priceFormatter(quote.getOpen().get(i)) : null)
          .high(i < quote.getHigh().size() ? priceFormatter(quote.getHigh().get(i)) : null)
          .low(i < quote.getLow().size() ? priceFormatter(quote.getLow().get(i)) : null)
          .close(i < quote.getClose().size() ? priceFormatter(quote.getClose().get(i)) : null)
          .volume(
              i < quote.getVolume().size() ? quote.getVolume().get(i) : null)
          .build();

      tstocksPriceOhlcvRepository.save(entity);
    }
  }

  public Double priceFormatter(Double price){
    if (price == null) {
      return null; // 避免傳入 null 時發生錯誤
  }
    return BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  public List<TstocksPriceOhlcvEntity> getTenCandleStickData(String symbol,
      String validRange) {
    return this.tstocksPriceOhlcvRepository
        .findTop10BySymbolAndValidRangeOrderByTradeDateDesc(symbol, validRange);
  }

}
