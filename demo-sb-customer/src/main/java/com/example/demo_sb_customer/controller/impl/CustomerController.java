package com.example.demo_sb_customer.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_sb_customer.codewave.ApiResp;
import com.example.demo_sb_customer.codewave.Syscode;
import com.example.demo_sb_customer.controller.CustomerOperation;
import com.example.demo_sb_customer.entity.CustomerEntity;
import com.example.demo_sb_customer.service.CustomerService;

@RestController
public class CustomerController implements CustomerOperation {
  @Autowired
  private CustomerService customerService;

  @Override
  public ApiResp<List<CustomerEntity>> getCustomers() {
    List<CustomerEntity> customerEntities = this.customerService.getCustomers();
    return ApiResp.<List<CustomerEntity>>builder() //
        .syscode(Syscode.OK) //
        .data(customerEntities) //
        .build();
  }

  // @Override
  // public List<CustomerEntity> getCustomers(){
  //   return this.customerService.getCustomers();
  // }

  @Override
  public ApiResp<CustomerEntity> createCustomer(CustomerEntity customerEntity) {
    CustomerEntity serviceResult =
        this.customerService.createCustomer(customerEntity);
    return ApiResp.<CustomerEntity>builder().syscode(Syscode.OK)
        .data(serviceResult).build();
  }

  @Override
  public Optional<CustomerEntity> getOptionalId(Long id) {
    return this.customerService.getCustomerById(id);
  }


}
