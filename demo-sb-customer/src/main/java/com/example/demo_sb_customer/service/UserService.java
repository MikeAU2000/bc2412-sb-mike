package com.example.demo_sb_customer.service;

import java.util.List;
import com.example.demo_sb_customer.model.dto.UserDto;

public interface UserService {
  List<UserDto> getUsers();
}
