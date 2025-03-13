package com.example.demo_web_side.Service;

import java.util.List;
import com.example.demo_web_side.dto.CryptoWebDTO;

public interface CoinService {
  List<CryptoWebDTO> getCoinMarket();
}
