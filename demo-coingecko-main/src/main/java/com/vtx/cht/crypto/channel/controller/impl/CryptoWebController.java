package com.vtx.cht.crypto.channel.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtx.cht.crypto.channel.controller.CryptoWebOperation;
import com.vtx.cht.crypto.channel.dto.BasicInforWebDTO;
import com.vtx.cht.crypto.channel.dto.CryptoWebDTO;
import com.vtx.cht.crypto.channel.dto.mapper.DTOMapper;
import com.vtx.cht.crypto.channel.model.dto.CoinGeckoMarketDto;
import com.vtx.cht.crypto.channel.service.CoinGeckoService;

// http://localhost:8085/crypto/api/v1/coin/market
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/crypto/api/v1")
public class CryptoWebController implements CryptoWebOperation {
  @Autowired
  private CoinGeckoService coinGeckoService;

  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<CryptoWebDTO> getCoinMarket() {
    return coinGeckoService.getCoinMarket() //
        .stream() //
        .map(e -> dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }

  public List<BasicInforWebDTO> getBasicInfor() {
    return coinGeckoService.getCoinMarket()
        .stream()
        .map(e -> dtoMapper.frontendmap(e))
        .collect(Collectors.toList());
  }

  @Override
  public List<CoinGeckoMarketDto> getOgCoinMarket() {
    return coinGeckoService.getOrgCoinMarket();
  }
}
