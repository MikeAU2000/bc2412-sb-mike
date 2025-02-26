package com.example.demo_frontend_project.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo_frontend_project.codewave.RedisManager;
import com.example.demo_frontend_project.dto.BitcoinDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ServiceImpl {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  // private RedisTemplate<String, String> redisTemplate;
  private RedisManager redisManager;


  public List<BitcoinDTO> getDto() throws JsonProcessingException {
    String url =
        "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";
    BitcoinDTO[] redisData =
        this.redisManager.get("jph-users", BitcoinDTO[].class);
    if (redisData != null) {
      return Arrays.asList(redisData);
    } else {
      List<BitcoinDTO> replyDtos = Arrays
          .asList(this.restTemplate.getForObject(url, BitcoinDTO[].class));
      this.redisManager.set("jph-users", replyDtos, Duration.ofMinutes(1));
      return Arrays
          .asList(this.restTemplate.getForObject(url, BitcoinDTO[].class));
    }
  }

}
