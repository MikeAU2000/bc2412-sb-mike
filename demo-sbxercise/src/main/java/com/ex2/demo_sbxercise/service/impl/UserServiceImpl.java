package com.ex2.demo_sbxercise.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ex2.demo_sbxercise.dio.CommentDto;
import com.ex2.demo_sbxercise.dio.PostDto;
import com.ex2.demo_sbxercise.dio.UserDto;
import com.ex2.demo_sbxercise.service.UserService;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<UserDto> getUsers() {
    String url1 = "https://jsonplaceholder.typicode.com/users";
    return Arrays.asList(this.restTemplate.getForObject(url1, UserDto[].class));
  }

  @Override
  public List<PostDto> getPosts() {
    String url2= "https://jsonplaceholder.typicode.com/posts";
    return Arrays.asList(this.restTemplate.getForObject(url2,PostDto[].class));
  }

  @Override
  public List<CommentDto> getComment() {
    String url3= "https://jsonplaceholder.typicode.com/comments";
    return Arrays.asList(this.restTemplate.getForObject(url3,CommentDto[].class));
  }

  
  
}
