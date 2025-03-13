package com.example.demo_web_side.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo_web_side.Service.impl.CoinServiceImpl;
import com.example.demo_web_side.dto.CryptoWebDTO;



@Controller
public class ViewController {
  @Autowired
  private CoinServiceImpl coinServiceImpl;

  @GetMapping(value = "/bootcamp")
  public String sayHelloPage(Model model) {
    model.addAttribute("tutor","vincent");
      return "hello";
  }

  @GetMapping(value = "/coin")
  public String showCoin(Model model) {
     List<CryptoWebDTO> cryptoList=coinServiceImpl.getCoinMarket();
    model.addAttribute("coin",cryptoList);
      return "coin";
  }
  
  
}
