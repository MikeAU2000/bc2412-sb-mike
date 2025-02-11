package com.example.demo_sb_customer.controller;

import com.example.demo_sb_customer.codewave.ApiResp;
import com.example.demo_sb_customer.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



public interface CustomerOperation {

  @GetMapping(value = "/customers")
  ApiResp<List<CustomerEntity>> getCustomers();

  // @GetMapping(value = "/customers")
  // List<CustomerEntity> getCustomers();

  
  @PostMapping(value = "/customer")
  ApiResp<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity);

  @GetMapping(value = "/getCustomers")
  Optional<CustomerEntity> getOptionalId(@RequestParam Long id);
  
}
