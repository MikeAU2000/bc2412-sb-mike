package com.ex2.demo_sbxercise.dio;

import lombok.Getter;

@Getter
public class CommentDto {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
