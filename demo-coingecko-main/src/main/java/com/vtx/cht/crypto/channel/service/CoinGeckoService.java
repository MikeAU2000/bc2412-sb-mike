package com.vtx.cht.crypto.channel.service;

import java.util.List;
import com.vtx.cht.crypto.channel.model.CoinMarket;
import com.vtx.cht.crypto.channel.model.dto.CoinGeckoMarketDto;

public interface CoinGeckoService {
  List<CoinMarket> getCoinMarket();
  List<CoinGeckoMarketDto> getOrgCoinMarket();
}
