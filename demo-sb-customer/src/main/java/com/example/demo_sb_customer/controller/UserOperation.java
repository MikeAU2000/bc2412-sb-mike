package com.example.demo_sb_customer.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.dto.UserDTO;

public interface UserOperation {
  
  @GetMapping(value = "/jsonplaceholder/users")
  public List<UserDTO> getUsers();
}
