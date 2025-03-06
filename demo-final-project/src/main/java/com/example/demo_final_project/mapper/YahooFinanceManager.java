package com.example.demo_final_project.mapper;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.example.demo_final_project.dto.QuoteResponseDto;

@Component
public class YahooFinanceManager {
  @Autowired
  private CrubManager crubManager;

  @Autowired
  private RestTemplate restTemplate;


  private static final String COOKIE = "B=12345abcde; GUC=AQEBCAFZ..."; // 你的 Cookie
  private static final String USER_AGENT =
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

  public QuoteResponseDto getQuoteResponseDto() {
    String url =
        "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb="
            + crubManager.getKey();

    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.USER_AGENT, USER_AGENT);
    headers.set(HttpHeaders.COOKIE, COOKIE);

    HttpEntity<String> entity = new HttpEntity<>(headers);
    ResponseEntity<QuoteResponseDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, QuoteResponseDto.class);

    return response.getBody();

    // QuoteResponseDto quoteResponseDto =
    //     this.restTemplate.getForObject(url, QuoteResponseDto.class);
    // return quoteResponseDto;
  }

}
