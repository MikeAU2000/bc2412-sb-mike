package com.ex2.demo_sbxercise.service;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.ex2.demo_sbxercise.Dto.CommentByuserDTO;
import com.ex2.demo_sbxercise.Dto.UpcDTO;
import com.ex2.demo_sbxercise.entity.CommentEntity;
import com.ex2.demo_sbxercise.entity.PostEntity;
import com.ex2.demo_sbxercise.entity.UserEntity;

public interface UpcSservice {
  List<UpcDTO> getUpc();

  List<CommentByuserDTO> getCommentByUser();

  CommentByuserDTO getcby(Long id);

  void saveAllUsersEntity();

  void saveAllPostEntity();

  void saveAllCommentEntity();

  UserEntity putUserEntity(@RequestParam(value = "userId") Long id,
  @RequestBody UserEntity userEntity);

  void deletPostByPostId(@PathVariable Long postId);

  void deletCommentByPostId(Long postId);

  void addPostByUserId(@PathVariable (value = "userId")Long userId
  ,@RequestBody PostEntity postEntity
  );

  void addCommentByPostId(@RequestParam Long postId,
  @RequestBody CommentEntity commentEntity);

  void updateCommentByCommentId(@RequestParam Long commentId,
  @RequestBody CommentEntity commentEntity);
}

 