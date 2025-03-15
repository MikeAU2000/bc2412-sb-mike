package com.example.project.demo_bc_xfin_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.project.demo_bc_xfin_service.entity.TstocksPriceOhlcvEntity;
import com.example.project.demo_bc_xfin_service.service.dailyChartsService.DbUpload;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DayChartsOperation {
  @Autowired
  private DbUpload dbUpload;

  @PostMapping("/dailyData/{symbols}")
  public void postMethodName(@PathVariable("symbols") String sym)
      throws JsonProcessingException {
    dbUpload.saveStockDataFromDTO(sym);
  }

  //http://localhost:8100/tenCandleStick?symbol=0388.HK&vaildRange=1d
  @CrossOrigin
  @GetMapping("/tenCandleStick")
  public List<TstocksPriceOhlcvEntity> getMethodName(@RequestParam String symbol, @RequestParam String vaildRange) {
      return dbUpload.getTenCandleStickData(symbol, vaildRange);
  }
  
}
