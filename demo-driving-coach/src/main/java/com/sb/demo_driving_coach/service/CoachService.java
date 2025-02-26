package com.sb.demo_driving_coach.service;

import java.util.List;
import com.sb.demo_driving_coach.entity.CoachEntity;

public interface CoachService {
  List<CoachEntity> getCoaches();
  CoachEntity createCoach(CoachEntity coachEntity);
}
