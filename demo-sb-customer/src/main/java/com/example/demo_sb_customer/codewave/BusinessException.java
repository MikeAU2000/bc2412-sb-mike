package com.example.demo_sb_customer.codewave;

public class BusinessException extends RuntimeException{
  private Syscode syscode;
  
  public static BusinessException of(Syscode syscode){
    return new BusinessException(syscode);
  }
  private BusinessException(Syscode sysCode){
    super(sysCode.getMessage());
    this.syscode= sysCode;
  }

  public Syscode getSysCode(){
    return this.syscode;
  }
}
