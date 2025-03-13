package com.example.project.demo_bc_xfin_service.service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.demo_bc_xfin_service.codewave.RedisManager;
import com.example.project.demo_bc_xfin_service.dto.QuoteResponseDto;
import com.example.project.demo_bc_xfin_service.entity.TstocksEntity;
import com.example.project.demo_bc_xfin_service.entity.TstocksPriceEntity;
import com.example.project.demo_bc_xfin_service.manager.CrubManager;
import com.example.project.demo_bc_xfin_service.manager.YahooFinanceManager;
import com.example.project.demo_bc_xfin_service.manager.YahooService;
import com.example.project.demo_bc_xfin_service.repository.TstocksPriceRepository;
import com.example.project.demo_bc_xfin_service.repository.TstocksRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class StockServiceimpl {


  @Autowired
  private TstocksRepository tstocksRepository;

  @Autowired
  private RedisManager redisManager;

  @Autowired
  private TstocksPriceRepository tstocksPriceRepository;

  @Autowired
  private YahooService yahooService;

  @Autowired
  private CrubManager crubManager;

  @Autowired
  private YahooFinanceManager yahooFinanceManager;


  public QuoteResponseDto getYahooData(String num) {
    String cookies = yahooService.getYahooCookies();
    String key = crubManager.getKey(cookies);
    QuoteResponseDto quoteResponseDto =
        yahooFinanceManager.getQuoteResponseDto(num, key, cookies);
    return quoteResponseDto;
  }

  public Map<String, List<String>> getStockList()
      throws JsonProcessingException {
    Map<String, List<String>> stockMap = new HashMap<>();
    String[] redisData = this.redisManager.get("stocka", String[].class);
    if (redisData != null) {
      stockMap.put("STOCK-LIST", Arrays.asList(redisData));
      return stockMap;
    }
    List<String> stockList = new ArrayList<>();
    for (TstocksEntity tstocksEntity : tstocksRepository.findAll()) {
      stockList.add(tstocksEntity.getSymbol());
    }
    stockMap.put("STOCK-LIST", stockList);
    this.redisManager.set("stocka", stockList, Duration.ofDays(1));

    return stockMap;
  }

  public TstocksPriceEntity savetstocksPriceEntity(String symbol) throws JsonProcessingException {
    QuoteResponseDto.Result quoteResponseDto =
        getYahooData(symbol).getQuoteResponse().getResult().get(0);
    TstocksPriceEntity stockPrice = new TstocksPriceEntity();
    if(quoteResponseDto.getMarketState().equals("PRE")){
      this.redisManager.delete(symbol);
    }
    if (!(quoteResponseDto.getMarketState().equals("REGULAR"))) {
      return stockPrice;
    }
    if (quoteResponseDto.getRegularMarketTime()==(tstocksPriceRepository.findTopBySymbolOrderByRegularMarketTimeDesc(symbol).getRegularMarketTime())){
      return stockPrice;
    }
    stockPrice.setSymbol(quoteResponseDto.getSymbol());
    stockPrice.setRegularMarketTime(quoteResponseDto.getRegularMarketTime());
    stockPrice.setRegularMarketPrice(quoteResponseDto.getRegularMarketPrice());
    stockPrice.setRegularMarketChangePercent(
        quoteResponseDto.getRegularMarketChangePercent());
    stockPrice.setBid(quoteResponseDto.getBid());
    stockPrice.setBidSize(quoteResponseDto.getBidSize());
    stockPrice.setAsk(quoteResponseDto.getAsk());
    stockPrice.setAskSize(quoteResponseDto.getAskSize());
    stockPrice.setType("5M"); // 預設為 5 分鐘數據
    stockPrice.setApiDateTime(LocalDateTime.now());
    stockPrice.setMarketUnixTime(
        Instant.ofEpochSecond(quoteResponseDto.getRegularMarketTime())
            .atZone(ZoneId.systemDefault()).toLocalDateTime());
    tstocksPriceRepository.save(stockPrice);
    List<TstocksPriceEntity> priceList= getRecordsBySymbolAndDate(symbol, LocalDate.now());
    this.redisManager.delete(symbol);
    this.redisManager.set(symbol, priceList, Duration.ofDays(7));
    //System.out.println("print 1");
    return stockPrice;
  }

  public List<TstocksPriceEntity> getRecordsBySymbolAndDate(String symbol,
      LocalDate data) throws JsonProcessingException {
        // TstocksPriceEntity[] redisData = this.redisManager.get(symbol, TstocksPriceEntity[].class);
        // if (redisData != null) {
        //   return Arrays.asList(redisData);
        // }
    LocalDateTime startOfDay = data.atStartOfDay();
    LocalDateTime endOfDay = data.atTime(23, 59, 59);

    List<TstocksPriceEntity> priceList=tstocksPriceRepository.findAllBySymbolAndApiDateTimeBetween(symbol,
        startOfDay, endOfDay);

        //this.redisManager.set(symbol, priceList, Duration.ofMinutes(5));

        return priceList;
  }

  public List<TstocksPriceEntity> getRedisData(String symbol) throws JsonProcessingException {
    List<TstocksPriceEntity> redisList= new ArrayList<>();
    TstocksPriceEntity[] redisData = this.redisManager.get(symbol, TstocksPriceEntity[].class);
    if(redisData != null){
      return Arrays.asList(redisData);
    }
    return redisList;
  }

  public TstocksEntity saveStock(String symbol) throws JsonProcessingException {
    TstocksEntity tstocksEntity= TstocksEntity.builder().symbol(symbol).build();
    List<String> stockSymbols= new ArrayList<>();
    List<TstocksEntity>tstocksEntityList=tstocksRepository.findAll();
      for (TstocksEntity t : tstocksEntityList) {
        stockSymbols.add(t.getSymbol());
      }
      stockSymbols.add(symbol);
      this.redisManager.set("stocks", stockSymbols);
    return tstocksRepository.save(tstocksEntity);
  }
}
