package com.bootcamp.web.demo_coin_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @RestController // return JSON as response
@Controller // return html
public class ViewController {

  @GetMapping(value = "/bootcamp")
  public String sayHelloPage(Model model) {
    model.addAttribute("tutor", "vincent");

    return "hello"; // html file name
  }
}
