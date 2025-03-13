package com.example.demo_frontend_project.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo_frontend_project.codewave.RedisManager;
import com.example.demo_frontend_project.dto.BitcoinDTO;
import com.example.demo_frontend_project.dto.CandlestickChartDTO;
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

  public List<CandlestickChartDTO> getCandlestickChartDTOs() throws JsonProcessingException {
    String url = "https://api.coingecko.com/api/v3/coins/bitcoin/ohlc?vs_currency=usd&days=1";
    
    CandlestickChartDTO[] redisData = this.redisManager.get("candlestickChart", CandlestickChartDTO[].class);
    if (redisData != null) {
        return Arrays.asList(redisData);
    } else {
        // 获取原始数组数据
        Long[][] rawData = this.restTemplate.getForObject(url, Long[][].class);
        List<CandlestickChartDTO> chartData = new ArrayList<>();
        
        // 转换数据格式
        for (Long[] dataPoint : rawData) {
            CandlestickChartDTO dto = CandlestickChartDTO.builder()
                .timestamp(dataPoint[0])
                .open(dataPoint[1].doubleValue())
                .high(dataPoint[2].doubleValue())
                .low(dataPoint[3].doubleValue())
                .close(dataPoint[4].doubleValue())
                .build();
            chartData.add(dto);
        }
        
        this.redisManager.set("candlestickChart", chartData, Duration.ofMinutes(1));
        return chartData;
    }
  }

}
