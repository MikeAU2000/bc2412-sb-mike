package com.mtr.demo_bc_mtr_stations.service;

import com.mtr.demo_bc_mtr_stations.Dtos.GetAllLinesignalDTO;
import com.mtr.demo_bc_mtr_stations.model.LineId;

public interface GetAllLineSignalService {
  GetAllLinesignalDTO getAllSignal(LineId lineId);
}
