package com.mtr.demo_bc_mtr_stations.Dtos;

import java.util.List;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import com.mtr.demo_bc_mtr_stations.model.StationId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLinesignalDTO {
  private LineId lineId;
  private String signal;
  private List<StationId> delayStation;
  private String curr_time;
  private String sys_tiem;
}
