package com.mtr.demo_bc_mtr_stations.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MtrDto {
  @JsonFormat(pattern = "yyyy-MM-dd H:mm:ss")
  private LocalDateTime sys_time;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime curr_time;
  private Map<String, TrainLineData> data;
  private String isdelay;

  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class TrainLineData {
    @JsonFormat(pattern = "yyyy-MM-dd H:mm:ss")
    private LocalDateTime sys_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime curr_time;
    @JsonProperty("UP") 
    private List<Up> up;
    @JsonProperty("DOWN")
    private List<Down> down;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Up {
      private String ttnt;
      private String valid;
      private String plat;
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime time;
      private String source;
      private String dest;
      private String seq;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Down {
      private String ttnt;
      private String valid;
      private String plat;
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime time;
      private String source;
      private String dest;
      private String seq;
    }
  }
}
