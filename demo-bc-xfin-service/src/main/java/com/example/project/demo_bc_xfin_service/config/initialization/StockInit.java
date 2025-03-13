package com.example.project.demo_bc_xfin_service.config.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.project.demo_bc_xfin_service.entity.TstocksEntity;
import com.example.project.demo_bc_xfin_service.repository.TstocksRepository;
import jakarta.transaction.Transactional;

@Component
public class StockInit {
  @Autowired
  private TstocksRepository tstocksRepository;

  @Transactional
  public void initializeStocks(){
    TstocksEntity stock1= TstocksEntity.builder().symbol("0388.HK").build();
    TstocksEntity stock2= TstocksEntity.builder().symbol("0700.HK").build();
    TstocksEntity stock3= TstocksEntity.builder().symbol("0005.HK").build();

    tstocksRepository.save(stock1);
    tstocksRepository.save(stock2);
    tstocksRepository.save(stock3);
  }
}
