package com.ex2.demo_sbxercise.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.ex2.demo_sbxercise.Dto.CommentByuserDTO;
import com.ex2.demo_sbxercise.dio.UserDto;
import com.ex2.demo_sbxercise.service.UpcSservice;
import com.ex2.demo_sbxercise.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @Autowired
  private UpcSservice upcSservice;

  @GetMapping(value = "/jsonplaceholder/users")
  public List<UserDto> getUsersControll() {
      return userService.getUsers();
  }


  
  
  @GetMapping(value = "/jsonplaceholder/upc")
  public CommentByuserDTO getCommentByUserControll(@RequestParam Long id) {
      return upcSservice.getcby(id);
  }
}
