package com.example.demo_sb_customer.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_sb_customer.controller.UserOperation;
import com.example.demo_sb_customer.service.UserService;
import com.example.dto.UserDTO;
import com.example.dto.mapper.UserDTOMapper;


@RestController
public class UserController implements UserOperation{
  @Autowired
  private UserService userService;

  @Autowired
  private UserDTOMapper userDTOMapper;

  public List<UserDTO> getUsers() {
    return this.userService.getUsers().stream()
        .map(e -> this.userDTOMapper.map(e))
        .collect(Collectors.toList());
  }

}
