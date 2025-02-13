package com.ex2.demo_sbxercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  @Bean 
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
