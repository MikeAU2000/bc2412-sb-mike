package com.mtr.demo_bc_mtr_stations.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mtr.demo_bc_mtr_stations.entity.LineEntity;
import com.mtr.demo_bc_mtr_stations.model.LineId;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, LineId>{
  Optional<LineEntity> findByLineId(LineId lineId);
}
