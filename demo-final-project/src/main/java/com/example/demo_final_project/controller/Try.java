package com.example.demo_final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_final_project.dto.QuoteResponseDto;
import com.example.demo_final_project.mapper.CrubManager;
import com.example.demo_final_project.mapper.YahooFinanceManager;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Try {
  @Autowired
  private CrubManager crubManager;

  @Autowired
  private YahooFinanceManager yahooFinanceManager;

  @GetMapping("/key")
  public String getMethodName() {
      return crubManager.getKey();
  }

  @GetMapping("/QuoteResponse")
  public QuoteResponseDto getQuoteResponseDto() {
      return yahooFinanceManager.getQuoteResponseDto();
  }
  
  
}
