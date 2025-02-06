package com.sb2.demo_restful.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cat {
  private long id;
  private String name;
  private int age;
}
