package com.sb2.demo_restful.controller;

import java.nio.file.OpenOption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.sb2.demo_restful.model.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value="/v1")
public class CalculatorController {
  @GetMapping(value = "/operation/{operation}")
  public Integer operate(@PathVariable Operation operation,
  @RequestParam Integer x, @RequestParam Integer y){
    return switch (operation){
      case SUM ->x+y;
      case SUBTRACT ->x-y;
      case MULTIPLY ->x*y;
      case DIVIDE -> {
        int result;
        try {
          result =x/y;
        } catch (ArithmeticException e) {
          result =0;
        }
        yield result;
      }
    };
  }
}
