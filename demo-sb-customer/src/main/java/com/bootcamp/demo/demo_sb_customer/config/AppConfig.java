package com.bootcamp.demo.demo_sb_customer.config;

import java.math.BigDecimal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // bean
public class AppConfig {
  // ! More than one methods for creating beans
  @Bean
  BigDecimal bigDecimal() {
    return BigDecimal.valueOf(10);
  }
  @Bean
  String tutor() {
    return "Vincent";
  }

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean 
  RedisTemplate<String, String> RedisTemplate(RedisConnectionFactory factory){
    RedisTemplate<String, String> redisTemplate
  }
  
}
