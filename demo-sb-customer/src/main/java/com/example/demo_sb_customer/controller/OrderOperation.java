package com.example.demo_sb_customer.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo_sb_customer.entity.OrderEntity;

public interface OrderOperation {
  
  @PostMapping(value = "/order")
  OrderEntity createOrder(@RequestParam(value = "cid") Long customerId,
    @RequestBody OrderEntity orderEntity);

  @DeleteMapping(value = "/order")
  void deleOrder(@RequestParam(value = "oid") Long orderId);
}
