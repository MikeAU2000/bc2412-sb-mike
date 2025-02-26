package com.mtr.demo_bc_mtr_stations.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.mtr.demo_bc_mtr_stations.service.impl.EarliestTrainImpl;
import com.mtr.demo_bc_mtr_stations.service.impl.GetAllLineSignalimpl;
import com.mtr.demo_bc_mtr_stations.service.impl.ServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;
import com.mtr.demo_bc_mtr_stations.Dtos.EarliestTrainDTO;
import com.mtr.demo_bc_mtr_stations.Dtos.GetAllLinesignalDTO;
import com.mtr.demo_bc_mtr_stations.controller.mtrOperation;
import com.mtr.demo_bc_mtr_stations.dto.MtrDto;
import com.mtr.demo_bc_mtr_stations.entity.StationEntity;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import com.mtr.demo_bc_mtr_stations.model.StationId;

@RestController
public class controllerImpl implements mtrOperation{
  @Autowired
  private ServiceImpl serviceImpl;

  @Autowired
  private EarliestTrainImpl earliestTrainImpl;

  @Autowired
  private GetAllLineSignalimpl getAllLineSignalimpl;

  
  public List<StationEntity> getStations(
      @RequestParam("lineId") LineId lineId
  ) {
      return serviceImpl.getStationEntities(lineId);
  }


  public Map<LineId,List<StationEntity>> getAllStations() {
      return serviceImpl.getAllStationEntities();
  }


  public MtrDto getMtrInfro(@RequestParam("line") LineId lineId, @RequestParam("sta") StationId stationId) {
      return earliestTrainImpl.getAllInfor(lineId, stationId);
  }
  

  public EarliestTrainDTO getTheEarliesTrain(@RequestParam("line") LineId lineId, @RequestParam("sta") StationId stationId) {
      return earliestTrainImpl.getTheEarliesTrain(lineId, stationId);
  }


  public GetAllLinesignalDTO getMethodName(@RequestParam("line") LineId lineId) {
      return this.getAllLineSignalimpl.getAllSignal(lineId);
  }
  
  
  
}
