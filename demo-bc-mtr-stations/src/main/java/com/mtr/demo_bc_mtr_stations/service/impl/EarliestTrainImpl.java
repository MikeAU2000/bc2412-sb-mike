package com.mtr.demo_bc_mtr_stations.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mtr.demo_bc_mtr_stations.Dtos.EarliestTrainDTO;
import com.mtr.demo_bc_mtr_stations.dto.MtrDto;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import com.mtr.demo_bc_mtr_stations.model.StationId;

@Service
public class EarliestTrainImpl {
  @Autowired
  private RestTemplate restTemplate;

  public MtrDto getAllInfor(LineId lineId, StationId stationId) {
    String url1 =
        "https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php?line=" + lineId
            + "&sta=" + stationId;
    return this.restTemplate.getForObject(url1, MtrDto.class);
  }

  public EarliestTrainDTO getTheEarliesTrain(LineId lineId,
      StationId stationId) {
    MtrDto orginDto = getAllInfor(lineId, stationId);
    List<EarliestTrainDTO.Train> trainList = new ArrayList<>();
    List<MtrDto.TrainLineData.Up> upList = new ArrayList<>();
    List<MtrDto.TrainLineData.Up> upOrginList =
        orginDto.getData().entrySet().iterator().next().getValue().getUp();
    if (upOrginList != null) {
      for (MtrDto.TrainLineData.Up up : upOrginList) {
        Boolean distinc = true;
        for (MtrDto.TrainLineData.Up up2 : upList) {
          if (up.getDest().equals(up2.getDest())) {
            distinc = false;
            break;
          }
        }
        if (distinc == true) {
          upList.add(up);
        }
      }
    }


    List<MtrDto.TrainLineData.Down> downList = new ArrayList<>();
    List<MtrDto.TrainLineData.Down> downOrginList =
        orginDto.getData().entrySet().iterator().next().getValue().getDown();

    if (downOrginList != null) {
      for (MtrDto.TrainLineData.Down down : downOrginList) {
        Boolean distinc = true;
        for (MtrDto.TrainLineData.Down down2 : downList) {
          if (down.getDest().equals(down2.getDest())) {
            distinc = false;
            break;
          }
        }
        if (distinc == true) {
          downList.add(down);
        }
      }
    }

    if (upList != null) {
      for (MtrDto.TrainLineData.Up up : upList) {
        trainList.add(EarliestTrainDTO.Train.builder().destination(up.getDest())
            .arrivalTime(up.getTime()).direction("UP").build());
      }
    }

    if (downList != null) {
      for (MtrDto.TrainLineData.Down down : downList) {
        trainList
            .add(EarliestTrainDTO.Train.builder().destination(down.getDest())
                .arrivalTime(down.getTime()).direction("DOWN").build());
      }
    }

    EarliestTrainDTO earliestTrainDTO =
        EarliestTrainDTO.builder().curr_time(orginDto.getCurr_time())
            .sys_time(orginDto.getSys_time()).currentStation(orginDto.getData()
                .entrySet().iterator().next().getKey().substring(4))
            .trains(trainList).build();
    return earliestTrainDTO;
  }

}
