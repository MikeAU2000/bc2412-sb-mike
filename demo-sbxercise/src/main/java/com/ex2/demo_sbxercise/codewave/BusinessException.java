package com.ex2.demo_sbxercise.codewave;

public class BusinessException extends RuntimeException{
  private SysCode syscode;

  public static BusinessException of(SysCode sysCode){
    return new BusinessException(sysCode);
  }

  private BusinessException(SysCode sysCode){
    super(sysCode.getMessage());
    this.syscode=sysCode;
  }

  public SysCode getSysCode(){
    return this.syscode;
  }
}
