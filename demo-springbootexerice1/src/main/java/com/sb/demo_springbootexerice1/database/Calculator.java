package com.sb.demo_springbootexerice1.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Calculator {
  private String x;
  private String y;
  private String operation;
}
