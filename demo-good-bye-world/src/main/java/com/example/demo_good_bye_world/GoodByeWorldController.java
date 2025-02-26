package com.example.demo_good_bye_world;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GoodByeWorldController {
  @GetMapping(value = "/goodBye")
  public String getMethodName() {
      return "Goodbye world";
  }
}
