package com.example.demo_sb_customer.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_sb_customer.controller.UserOperation;
import com.example.demo_sb_customer.service.UserService;
import com.example.dto.UserDTO;


@RestController
public class UserController implements UserOperation{
  @Autowired
  private UserService userService;

  public List<UserDTO> getUsers() {
    return this.userService.getUsers().stream()
        .map(e -> new UserDTO(e.getId(), e.getName(), e.getUsername(),
            e.getEmail(),
            new UserDTO.Address(e.getAddress().getStreet(),
                e.getAddress().getSuite(), e.getAddress().getCity(),
                e.getAddress().getZipcode(),
                new UserDTO.Address.Geo(e.getAddress().getGeo().getLatitude(),
                    e.getAddress().getGeo().getLongitude()))))


        .collect(Collectors.toList());
  }

}
