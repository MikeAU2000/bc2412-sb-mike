package com.example.demo_web_side.Service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo_web_side.Service.CoinService;
import com.example.demo_web_side.dto.CryptoWebDTO;

@Service
public class CoinServiceImpl implements CoinService{
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CryptoWebDTO> getCoinMarket() {
    String url =
        "http://localhost:8085/crypto/api/v1/coin/market";
        
    
    List<CryptoWebDTO> coinMarket = Arrays.asList(
        this.restTemplate.getForObject(url, CryptoWebDTO[].class));

    return coinMarket;
  }
  
}
