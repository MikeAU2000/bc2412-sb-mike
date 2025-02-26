package com.mtr.demo_bc_mtr_stations.service;

import java.util.List;
import java.util.Map;
import com.mtr.demo_bc_mtr_stations.entity.StationEntity;
import com.mtr.demo_bc_mtr_stations.model.LineId;

public interface MtrService {
  Map<LineId,List<StationEntity>> getAllStationEntities();
  List<StationEntity> getStationEntities(LineId lineId);
}
