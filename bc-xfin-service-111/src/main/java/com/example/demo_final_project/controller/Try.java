package com.example.demo_final_project.controller;


import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_final_project.Manger.CrubManager;
import com.example.demo_final_project.Manger.YahooFinanceAPI;
import com.example.demo_final_project.Manger.YahooFinanceManager;
import com.example.demo_final_project.Manger.YahooService;
import com.example.demo_final_project.dto.QuoteResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Try {
  @Autowired
  private YahooService yahooService;

  @Autowired
  private CrubManager crubManager;

  @Autowired
  private YahooFinanceManager yahooFinanceManager;


  // @GetMapping("/cookies")
  // public String getCookies() {
  //   System.out.println(yahooService.getYahooCookies());
  //     return yahooService.getYahooCookies();
  // }

  @GetMapping("/cookies")
  public String getCookies() throws IOException {
    System.out.println(yahooService.getYahooCookies());
      return YahooFinanceAPI.getNewCrumb();
  }

  @GetMapping("/json")
  public QuoteResponseDto getMethodName(@RequestParam (value = "number") String num) {
      String cookies= yahooService.getYahooCookies();
      String key= crubManager.getKey(cookies);
      QuoteResponseDto quoteResponseDto= yahooFinanceManager.getQuoteResponseDto(num,key,cookies);
      return quoteResponseDto;
  }

  
}
