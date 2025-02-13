package com.ex2.demo_sbxercise.codewave;

public enum SysCode {
  USER_NOT_FOUND("1", "USER not found"),
  INVALID_INPUT("2", "invalid input"),
  RestTemplate_Error("3", "RestTemplate_Error-JsonPlaceHolder"),;
  
  private final String code;
  private final String message;
  private SysCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return this.code;
  }
  public String getMessage() {
    return this.message;
  }
}
