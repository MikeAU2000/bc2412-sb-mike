package com.example.project.demo_bc_xfin_service.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.demo_bc_xfin_service.entity.TstocksPriceEntity;

public interface TstocksPriceRepository extends JpaRepository<TstocksPriceEntity, Integer>{
  
  List<TstocksPriceEntity> findAllBySymbolAndApiDateTimeBetween(
        String symbol, LocalDateTime start, LocalDateTime end);
  
  TstocksPriceEntity findTopBySymbolOrderByRegularMarketTimeDesc(String symbol);
}
