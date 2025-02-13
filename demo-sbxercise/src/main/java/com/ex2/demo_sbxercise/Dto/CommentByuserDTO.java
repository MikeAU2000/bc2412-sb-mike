package com.ex2.demo_sbxercise.Dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
public class CommentByuserDTO {
  private Long id;
  private String username;
  private List<Comment> comments; 

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Comment{
    private String name;
    private String email;
    private String body;
  }
}
