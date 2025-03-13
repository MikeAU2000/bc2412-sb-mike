package com.vtx.cht.crypto.channel.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtx.cht.crypto.channel.dto.BasicInforWebDTO;
import com.vtx.cht.crypto.channel.dto.CryptoWebDTO;
import com.vtx.cht.crypto.channel.model.dto.CoinGeckoMarketDto;


public interface CryptoWebOperation {

  @GetMapping("/coin/market")
  List<CryptoWebDTO> getCoinMarket();

  @GetMapping("/basicInfor")
  List<BasicInforWebDTO> getBasicInfor();

  @CrossOrigin
  @GetMapping("/coins/orgmarkets")
  List<CoinGeckoMarketDto> getOgCoinMarket();
}
