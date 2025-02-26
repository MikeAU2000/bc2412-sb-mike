package com.ex2.demo_sbxercise.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "comments")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class CommentEntity {

    @Id
    private Long id;

    @Column(length = 255, nullable = false)  // 字數限制 255
    private String name;

    @Column(length = 255, nullable = false)  // 字數限制 255
    private String email;

    @Column(length = 500, nullable = false)  // 可放寬字數
    private String body;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity postEntity;
}
