package com.example.project.demo_bc_xfin_service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.demo_bc_xfin_service.entity.StockPriceId;
import com.example.project.demo_bc_xfin_service.entity.TstocksPriceOhlcvEntity;

public interface TstocksPriceOhlcvRepository extends JpaRepository<TstocksPriceOhlcvEntity, StockPriceId>{
  List<TstocksPriceOhlcvEntity> findTop10BySymbolAndValidRangeOrderByTradeDateDesc(String symbol, String validRange);
}
