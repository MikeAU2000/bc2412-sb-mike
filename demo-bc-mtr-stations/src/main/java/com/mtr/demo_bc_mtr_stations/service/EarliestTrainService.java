package com.mtr.demo_bc_mtr_stations.service;

import com.mtr.demo_bc_mtr_stations.Dtos.EarliestTrainDTO;
import com.mtr.demo_bc_mtr_stations.dto.MtrDto;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import com.mtr.demo_bc_mtr_stations.model.StationId;

public interface EarliestTrainService {
  MtrDto getAllInfor(LineId lineId, StationId stationId);
  EarliestTrainDTO getTheEarliesTrain(LineId lineId,
      StationId stationId);
}
