package com.example.demo_sb_customer.codewave;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobaExceptionHandler {
  @ExceptionHandler(
    BusinessException.class)
    public ApiResp<Void> handleBusinessExecption(BusinessException e){
      return ApiResp.<Void>builder().syscode(e.getSysCode()).build();
    }

    @ExceptionHandler(
      NullPointerException.class)
      public ApiResp<Void> handleNullPoinerException(){
        return ApiResp.<Void>builder()
        .syscode(Syscode.RTE_NPE)
        .build();
      }
}
