package com.sb.demo_springbootexerice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sb.demo_springbootexerice1.database.Calculator;
import com.sb.demo_springbootexerice1.database.CalculatorAnswer;
import com.sb.demo_springbootexerice1.service.CalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value ="v1")
public class CalculatorController {
  @Autowired
  private CalculatorService calculatorService;
  @PostMapping("/calculator")
  public CalculatorAnswer postMethodName(@RequestBody Calculator calculator) {
      return calculatorService.operate(calculator);
  }

  //http://localhost:8082/v1/operation/SUM?x=1&y=2
  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  @ResponseStatus(HttpStatus.OK)
  public CalculatorAnswer operate1(@PathVariable String x,
  @PathVariable String y, @PathVariable String operation){
    return this.calculatorService.operate(new Calculator(x,y,operation));
  }

  @GetMapping(value = "/operation")
  @ResponseStatus(HttpStatus.OK)
  public CalculatorAnswer operate2(@RequestParam String x,
  @RequestParam String y, @RequestParam String operation){
    return this.calculatorService.operate(new Calculator(x,y,operation));
  }
  
}
