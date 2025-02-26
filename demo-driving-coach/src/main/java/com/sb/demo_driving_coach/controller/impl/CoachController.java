package com.sb.demo_driving_coach.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.sb.demo_driving_coach.controller.CoachOperation;
import com.sb.demo_driving_coach.entity.CoachEntity;
import com.sb.demo_driving_coach.service.CoachService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CoachController implements CoachOperation{
  @Autowired
  private CoachService coachService;


  @Override
  public CoachEntity createCoach(CoachEntity coachEntity) {
    return this.coachService.createCoach(coachEntity);
  }

  @Override
  public List<CoachEntity> getCoaches() {
    return this.coachService.getCoaches();
  }
  
}
