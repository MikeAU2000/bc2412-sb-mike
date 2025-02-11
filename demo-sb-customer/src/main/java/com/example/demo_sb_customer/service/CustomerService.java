package com.example.demo_sb_customer.service;

import java.util.List;
import java.util.Optional;
import com.example.demo_sb_customer.entity.CustomerEntity;

public interface CustomerService {
  List<CustomerEntity> getCustomers();
  CustomerEntity createCustomer(CustomerEntity customerEntity);
  Optional<CustomerEntity> getCustomerById(Long id);
}
