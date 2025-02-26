package com.sb.demo_driving_coach.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Coach")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoachEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String location;
  private String description;
  private String carType;
  private Double lessonPrice;
  private Double extraLessonPrice;
  private String image;
}
