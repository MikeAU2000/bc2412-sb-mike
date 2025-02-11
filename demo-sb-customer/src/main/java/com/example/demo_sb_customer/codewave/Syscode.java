package com.example.demo_sb_customer.codewave;

public enum Syscode {
  OK("000000","Success."),
  ID_NOT_FOUND("900001","ID not found."),
  RTE_NPE("999999", "Null Pointer Exception."),
  ;

  private final String code;
  private final String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  
}
