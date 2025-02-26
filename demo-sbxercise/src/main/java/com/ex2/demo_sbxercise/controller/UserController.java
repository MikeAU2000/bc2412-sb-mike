package com.ex2.demo_sbxercise.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.ex2.demo_sbxercise.Dto.CommentByuserDTO;
import com.ex2.demo_sbxercise.dio.UserDto;
import com.ex2.demo_sbxercise.entity.CommentEntity;
import com.ex2.demo_sbxercise.entity.PostEntity;
import com.ex2.demo_sbxercise.entity.UserEntity;
import com.ex2.demo_sbxercise.repository.CommentRespository;
import com.ex2.demo_sbxercise.service.UpcSservice;
import com.ex2.demo_sbxercise.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;





@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @Autowired
  private UpcSservice upcSservice;

  @Autowired
  private CommentRespository commentRespository;

  @GetMapping(value = "/jsonplaceholder/users")
  public List<UserDto> getUsersControll() {
      return userService.getUsers();
  }

  @GetMapping(value = "/jsonplaceholder/upc")
  public CommentByuserDTO getCommentByUserControll(@RequestParam Long id) {
      return upcSservice.getcby(id);
  }

  @PutMapping(value = "/putUser")
  public UserEntity putUser(@RequestParam Long id, @RequestBody UserEntity userEntity) {
      return upcSservice.putUserEntity(id,userEntity);
  }

  @DeleteMapping("/deletePost/{postId}")
  public void deleteById(@PathVariable Long postId){
    commentRespository.deleteByPostEntity_Id(postId);
    upcSservice.deletPostByPostId(postId);
  }

  @PostMapping(value = "/addPostByUserId/{userId}")
  public void addPostByUserId(@PathVariable (value = "userId")Long userId
  ,@RequestBody PostEntity postEntity) {
      upcSservice.addPostByUserId(userId, postEntity);
  }

  @PostMapping(value = "/addCommentByPostId")
  public void postMethodName(@RequestParam Long postId,
  @RequestBody CommentEntity commentEntity) {
      upcSservice.addCommentByPostId(postId, commentEntity);
  }
  
  @PatchMapping(value = "/updateCommentByCommentId")
  public void updateCommentByCommentId(@RequestParam Long commentId,
  @RequestBody CommentEntity commentEntity) {
        upcSservice.updateCommentByCommentId(commentId, commentEntity);
  }
}
