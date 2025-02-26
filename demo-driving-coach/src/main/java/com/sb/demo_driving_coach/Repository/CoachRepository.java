package com.sb.demo_driving_coach.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sb.demo_driving_coach.entity.CoachEntity;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity,Long>{
  
}
