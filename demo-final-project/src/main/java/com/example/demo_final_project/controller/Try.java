package com.example.demo_final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_final_project.mapper.CrubManager;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Try {
  @Autowired
  private CrubManager crubManager;

  @GetMapping("/key")
  public String getMethodName() {
      return crubManager.getKey();
  }
  
}
