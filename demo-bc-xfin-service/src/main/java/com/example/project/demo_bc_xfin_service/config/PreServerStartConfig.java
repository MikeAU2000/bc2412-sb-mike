package com.example.project.demo_bc_xfin_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.project.demo_bc_xfin_service.codewave.RedisManager;
import com.example.project.demo_bc_xfin_service.config.initialization.StockInit;
import com.example.project.demo_bc_xfin_service.repository.TstocksRepository;

@Component
public class PreServerStartConfig implements CommandLineRunner{
  @Autowired
  private TstocksRepository tstocksRepository;

  @Autowired
  private StockInit stockInit;

  @Autowired
  private RedisManager redisManager;

  @Override
  public void run(String... args) throws Exception {
    redisManager.delete("stock");
    if (tstocksRepository.count() == 0) {
      stockInit.initializeStocks();
    }
  }
}
