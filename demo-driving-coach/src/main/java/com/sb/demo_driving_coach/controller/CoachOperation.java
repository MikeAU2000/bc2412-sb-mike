package com.sb.demo_driving_coach.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.sb.demo_driving_coach.entity.CoachEntity;


public interface CoachOperation {
  @GetMapping(value = "/coaches")
  @ResponseStatus(HttpStatus.OK)
  List<CoachEntity> getCoaches();

  @PostMapping(value = "/coach")
  @ResponseStatus(HttpStatus.CREATED)
  CoachEntity createCoach(@RequestBody CoachEntity coachEntity);
}
