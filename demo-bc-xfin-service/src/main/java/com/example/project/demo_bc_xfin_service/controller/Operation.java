package com.example.project.demo_bc_xfin_service.controller;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.project.demo_bc_xfin_service.dto.QuoteResponseDto;
import com.example.project.demo_bc_xfin_service.entity.TstocksEntity;
import com.example.project.demo_bc_xfin_service.entity.TstocksPriceEntity;
import com.example.project.demo_bc_xfin_service.manager.YahooFinanceAPI;
import com.example.project.demo_bc_xfin_service.manager.YahooService;
import com.example.project.demo_bc_xfin_service.service.StockServiceimpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
public class Operation {
  @Autowired
  private YahooService yahooService;

  @Autowired
  private StockServiceimpl stockServiceimpl;


  @GetMapping("/cookies")
  public String getCookies() throws IOException {
    System.out.println(yahooService.getYahooCookies());
    return YahooFinanceAPI.getNewCrumb();
  }

  @GetMapping("/json")
  public QuoteResponseDto getMethodName(
      @RequestParam(value = "number") String num) {
    return stockServiceimpl.getYahooData(num);
  }

  @PostMapping("/stock")
  public TstocksEntity postMethodName(@PathVariable("symbols") String sym) throws JsonProcessingException {
      return stockServiceimpl.saveStock(sym);
  }
  

  @GetMapping("/stocklist")
  public Map<String, List<String>> getStockList()
      throws JsonProcessingException {
    return stockServiceimpl.getStockList();
  }

  @GetMapping("/dayprice")
  public List<TstocksPriceEntity> getDayPrice(@RequestParam (value = "number") String num,
  @RequestParam (value = "day") LocalDate day) throws JsonProcessingException {
      return stockServiceimpl.getRecordsBySymbolAndDate(num, day);
  }

  @CrossOrigin
  @GetMapping("/redisdata")
  public List<TstocksPriceEntity> getDayPrice(@RequestParam (value = "number") String num) throws JsonProcessingException {
      return stockServiceimpl.getRedisData(num);
  }


}


