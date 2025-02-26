package com.sb.demo_driving_coach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sb.demo_driving_coach.Repository.CoachRepository;
import com.sb.demo_driving_coach.entity.CoachEntity;
import com.sb.demo_driving_coach.service.CoachService;

@Service
public class CoachServiceimpl implements CoachService{
  @Autowired
  private CoachRepository coachRepository;

  @Override
  public List<CoachEntity> getCoaches() {
    return this.coachRepository.findAll();
  }

  @Override
  public CoachEntity createCoach(CoachEntity coachEntity) {
    return this.coachRepository.save(coachEntity);
  }
  
}
