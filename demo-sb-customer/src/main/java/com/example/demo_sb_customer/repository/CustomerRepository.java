package com.example.demo_sb_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_sb_customer.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
  
}
