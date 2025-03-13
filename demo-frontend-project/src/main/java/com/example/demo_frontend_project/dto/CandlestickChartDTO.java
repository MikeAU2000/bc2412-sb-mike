package com.example.demo_frontend_project.dto;

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
public class CandlestickChartDTO {
  private long timestamp;
  private double open;
  private double high;
  private double low;
  private double close;
}
