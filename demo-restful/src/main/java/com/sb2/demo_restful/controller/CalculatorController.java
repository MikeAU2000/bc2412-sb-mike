package com.sb2.demo_restful.controller;

import java.nio.file.OpenOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sb2.demo_restful.Service.CalculatorService;
import com.sb2.demo_restful.model.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value="/v1")
//http://localhost:8082/v1/operation/SUM?x=3&y=3
public class CalculatorController {
  @Autowired
  private CalculatorService calculatorService;

  @GetMapping(value = "/operation/{operation}")
  @ResponseStatus(HttpStatus.OK)
  public Integer operate(@PathVariable Operation operation,
    @RequestParam Integer x, @RequestParam Integer y){
      return this.calculatorService.operate(operation, x,y);
    }

}
