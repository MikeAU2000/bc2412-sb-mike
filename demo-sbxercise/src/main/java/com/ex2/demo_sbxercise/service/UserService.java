package com.ex2.demo_sbxercise.service;

import java.util.List;
import com.ex2.demo_sbxercise.dio.CommentDto;
import com.ex2.demo_sbxercise.dio.PostDto;
import com.ex2.demo_sbxercise.dio.UserDto;

public interface UserService {
  List<UserDto> getUsers();
  List<PostDto> getPosts();
  List<CommentDto> getComment();
}




