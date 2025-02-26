package com.mtr.demo_bc_mtr_stations.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mtr.demo_bc_mtr_stations.Dtos.EarliestTrainDTO;
import com.mtr.demo_bc_mtr_stations.Dtos.GetAllLinesignalDTO;
import com.mtr.demo_bc_mtr_stations.dto.MtrDto;
import com.mtr.demo_bc_mtr_stations.entity.StationEntity;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import com.mtr.demo_bc_mtr_stations.model.StationId;

public interface mtrOperation {
  
  @GetMapping("/getStations")
  List<StationEntity> getStations(
      @RequestParam("lineId") LineId lineId
  );

  @GetMapping("/getAllStations")
  Map<LineId,List<StationEntity>> getAllStations();

  //https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php?line=SIL&sta=ADM
  @GetMapping("/getthetraininfro")
  MtrDto getMtrInfro(@RequestParam("line") LineId lineId, @RequestParam("sta") StationId stationId);
  
  //http://localhost:8100/getTheEarliesTrain?line=SIL&sta=ADM
  @GetMapping("/getTheEarliesTrain")
  EarliestTrainDTO getTheEarliesTrain(@RequestParam("line") LineId lineId, @RequestParam("sta") StationId stationId);

  @GetMapping("/getTheSignal")
  public GetAllLinesignalDTO getMethodName(@RequestParam("line") LineId lineId);
  
  
}
