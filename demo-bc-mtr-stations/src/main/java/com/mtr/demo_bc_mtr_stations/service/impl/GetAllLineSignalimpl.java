package com.mtr.demo_bc_mtr_stations.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mtr.demo_bc_mtr_stations.Dtos.GetAllLinesignalDTO;
import com.mtr.demo_bc_mtr_stations.dto.MtrDto;
import com.mtr.demo_bc_mtr_stations.entity.StationEntity;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import com.mtr.demo_bc_mtr_stations.model.StationId;
import com.mtr.demo_bc_mtr_stations.repository.LineRepository;
import com.mtr.demo_bc_mtr_stations.service.GetAllLineSignalService;

@Service
public class GetAllLineSignalimpl implements GetAllLineSignalService{
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LineRepository lineRepository;



  @SuppressWarnings("null")
  public GetAllLinesignalDTO getAllSignal(LineId lineId) {
    Set<StationEntity> stationSet=lineRepository.getReferenceById(lineId).getStations();
    List<StationId> stationIds= new ArrayList<>();
    Integer delayCount= 0;
    for (StationEntity stationEntity : stationSet) {
      StationId stationId= stationEntity.getStation_id();
      String url1 =
        "https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php?line=" + lineId
            + "&sta=" + stationId;
            MtrDto mtrDto=this.restTemplate.getForObject(url1, MtrDto.class);
      if (mtrDto.getIsdelay().equals("Y")) {
        delayCount++;
        stationIds.add(stationId);
      }
    }

    String signal="";
    if(delayCount==0){
      signal="GREEN";
    }else if(delayCount==1){
      signal="YELLOW";
    }else{
      signal="RED";
    }

    LocalDateTime now= LocalDateTime.now();
    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String time= now.format(formatter);
    return GetAllLinesignalDTO.builder().lineId(lineId).delayStation(stationIds).signal(signal).curr_time(time).sys_tiem(time).build();
  }
}
