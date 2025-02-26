package com.ex2.demo_sbxercise.entity;


import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Posts")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class PostEntity {
  @Id
  private Long id;
  private String title;
  private String body;
  @ManyToOne
  @JoinColumn (name = "user_id")
  private UserEntity userEntity;
}
