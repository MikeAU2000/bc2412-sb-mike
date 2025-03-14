package com.example.project.demo_bc_xfin_service.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.project.demo_bc_xfin_service.codewave.RedisManager;
import com.example.project.demo_bc_xfin_service.dto.QuoteResponseDto;
import com.example.project.demo_bc_xfin_service.entity.TstocksEntity;
import com.example.project.demo_bc_xfin_service.entity.TstocksPriceEntity;
import com.example.project.demo_bc_xfin_service.model.DTO.StockChartDTO;
import com.example.project.demo_bc_xfin_service.repository.TstocksPriceRepository;
import com.example.project.demo_bc_xfin_service.repository.TstocksRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class StockSchedulaerImpl {

  @Autowired
  private TstocksRepository tstocksRepository;

  @Autowired
  private RedisManager redisManager;

  @Autowired
  private StockServiceimpl stockServiceimpl;

  @Autowired
  private TstocksPriceRepository tstocksPriceRepository;


  @Scheduled(fixedRate = 300000) // 每5分鐘執行一次
  public void fetchStockData() throws JsonProcessingException {
    List<String> stockSymbols = new ArrayList<>();
    String[] redisData = this.redisManager.get("stocks", String[].class);
    if (redisData != null) {
      stockSymbols = Arrays.asList(redisData);
    } else {
      List<TstocksEntity> tstocksEntityList = tstocksRepository.findAll();
      for (TstocksEntity tstocksEntity : tstocksEntityList) {
        stockSymbols.add(tstocksEntity.getSymbol());
      }
      this.redisManager.set("stocks", stockSymbols);

    }
    List<StockChartDTO> stockChartDTOs = new ArrayList<>();
    for (String string : redisData) {
      QuoteResponseDto.Result quoteResponseDto = stockServiceimpl
          .getYahooData(string).getQuoteResponse().getResult().get(0);
      //TstocksPriceEntity stockPrice = new TstocksPriceEntity();
      if (quoteResponseDto.getMarketState().equals("PREPRE")
          || quoteResponseDto.getMarketState().equals("PRE")) {
        this.redisManager.delete(string);
        this.redisManager.delete("StockChartDTO-" + string);
      } else {
        stockServiceimpl.savetstocksPriceEntity(string);
        stockChartDTOs = stockServiceimpl.getStockChartDTO(string,
            tstocksPriceRepository
                .findTopBySymbolOrderByRegularMarketTimeDesc(string)
                .getApiDateTime().toLocalDate());
        this.redisManager.set("StockChartDTO-" + string, stockChartDTOs,
            Duration.ofDays(7));
      }
      System.out.println(LocalDateTime.now());
    }
  }


}
