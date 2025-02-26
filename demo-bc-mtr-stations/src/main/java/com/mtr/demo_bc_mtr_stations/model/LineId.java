package com.mtr.demo_bc_mtr_stations.model;


public enum LineId {
  AEL("Airport Express"),
  TCL("Tung Chung Line"),
  TML("Tuen Ma Line"),
  TKL("Tseung Kwan O Line"),
  EAL("East Rail Line"),
  SIL("South Island Line"),
  TWL("Tsuen Wan Line"),
  ISL("Island Line"),
  KTL("Kwun Tong Line"),
  ;

  private final String description;

  LineId(String description){
    this.description = description;
  }

  public String getDescription(){
    return description;
  }
}
