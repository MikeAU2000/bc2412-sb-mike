package com.sb.demo_springbootexerice1.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
public class CalculatorAnswer {
  private String x;
  private String y;
  private String operation;
  private String result;
}
