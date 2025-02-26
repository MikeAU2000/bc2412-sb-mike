package com.mtr.demo_bc_mtr_stations.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtr.demo_bc_mtr_stations.entity.LineEntity;
import com.mtr.demo_bc_mtr_stations.entity.StationEntity;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import com.mtr.demo_bc_mtr_stations.repository.LineRepository;
import com.mtr.demo_bc_mtr_stations.service.MtrService;

@Service
public class ServiceImpl implements MtrService{

  @Autowired
  private LineRepository lineRepository;

  public Map<LineId,List<StationEntity>> getAllStationEntities(){
    Map<LineId,List<StationEntity>> replyMap= new HashMap<>();
    List<LineEntity> lineList=lineRepository.findAll();
    for (LineEntity lineEntity : lineList) {
      replyMap.put(lineEntity.getLineId(), getStationEntities(lineEntity.getLineId()));
    }
    return replyMap;
  }


  public List<StationEntity> getStationEntities(LineId lineId){
    List<StationEntity> replyList= new ArrayList<>();
    if(lineRepository.findById(lineId).isPresent()){
      replyList=lineRepository.findById(lineId).get().getStationsList();
    }
    return replyList;
  }
}
