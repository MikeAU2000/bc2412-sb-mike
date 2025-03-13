package com.example.project.demo_bc_xfin_service.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.project.demo_bc_xfin_service.codewave.RedisManager;
import com.example.project.demo_bc_xfin_service.entity.TstocksEntity;
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

  @Scheduled(fixedRate = 300000) // 每5分鐘執行一次
  public void fetchStockData() throws JsonProcessingException {
    List<String> stockSymbols=new ArrayList<>();
    String[] redisData = this.redisManager.get("stocks", String[].class);
    if (redisData != null) {
     stockSymbols= Arrays.asList(redisData);
    }else{
      List<TstocksEntity>tstocksEntityList=tstocksRepository.findAll();
      for (TstocksEntity tstocksEntity : tstocksEntityList) {
        stockSymbols.add(tstocksEntity.getSymbol());
      }
      this.redisManager.set("stocks", stockSymbols);
    }
    for (String string : redisData) {
      stockServiceimpl.savetstocksPriceEntity(string);
        System.out.println(LocalDateTime.now());
    }
  }
}
