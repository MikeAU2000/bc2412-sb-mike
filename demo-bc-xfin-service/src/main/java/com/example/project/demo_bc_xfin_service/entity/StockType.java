package com.example.project.demo_bc_xfin_service.entity;

public enum StockType {
  FIVE_MINUTES("5M"), DAILY("D"), WEEKLY("W"), MONTHLY("M");

  private final String code;

  StockType(String code){
    this.code = code;
  }

  public String getCode(){
    return code;
  }

  public static StockType fromCode(String code) {
    for (StockType type : StockType.values()) {
        if (type.getCode().equals(code)) {
            return type;
        }
    }
    throw new IllegalArgumentException("Invalid StockType code: " + code);
}

}
