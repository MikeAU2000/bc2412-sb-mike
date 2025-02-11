package com.example.demo_sb_customer.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_sb_customer.codewave.BusinessException;
import com.example.demo_sb_customer.codewave.Syscode;
import com.example.demo_sb_customer.entity.CustomerEntity;
import com.example.demo_sb_customer.entity.OrderEntity;
import com.example.demo_sb_customer.repository.CustomerRepository;
import com.example.demo_sb_customer.repository.OrderRepository;
import com.example.demo_sb_customer.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public OrderEntity createOrder(Long customerId, OrderEntity orderEntity) {
    Optional<CustomerEntity> customerOpt =
        customerRepository.findById(customerId);
    if (!customerOpt.isPresent()) {
      throw BusinessException.of(Syscode.ID_NOT_FOUND);
    }

    CustomerEntity customer = customerOpt.get();
    orderEntity.setCustomerEntity(customer);

    return orderRepository.save(orderEntity);
  }

  @Override
  public void deletOrder(Long orderId) {
    orderRepository.deleteById(orderId);
  }

}
