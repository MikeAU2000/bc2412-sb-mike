package com.vtx.cht.crypto.channel.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtx.cht.crypto.channel.lib.RedisManager;

@Configuration
public class AppConfig {
  @Bean(name = "vincent")
  RestTemplate restTemplate2() {
    return new RestTemplate();
  }

  @Bean(name = "lucas")
  RestTemplate restTemplate1() {
    return new RestTemplate();
  }

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  RedisManager redisManager(RedisConnectionFactory factory, ObjectMapper objectMapper) {
    return new RedisManager(factory, objectMapper);
  }
}
