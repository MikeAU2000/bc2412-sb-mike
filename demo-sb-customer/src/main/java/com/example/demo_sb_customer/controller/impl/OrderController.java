package com.example.demo_sb_customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_sb_customer.controller.OrderOperation;
import com.example.demo_sb_customer.entity.OrderEntity;
import com.example.demo_sb_customer.service.OrderService;

@RestController
public class OrderController implements OrderOperation{
  @Autowired
  private OrderService orderService;
  
  @Override
  public OrderEntity createOrder(Long customerId, OrderEntity orderEntity) {
    return this.orderService.createOrder(customerId, orderEntity);
  }

  @Override
  public void deleOrder(Long orderId) {
    this.orderService.deletOrder(orderId);
  }
  
}
