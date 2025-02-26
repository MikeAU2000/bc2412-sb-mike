package com.mtr.demo_bc_mtr_stations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mtr.demo_bc_mtr_stations.entity.StationEntity;
import com.mtr.demo_bc_mtr_stations.model.StationId;

@Repository
public interface StationRepository extends JpaRepository<StationEntity,StationId>{
  
}
