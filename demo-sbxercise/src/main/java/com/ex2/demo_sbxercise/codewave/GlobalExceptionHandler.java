package com.ex2.demo_sbxercise.codewave;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(BusinessException.class)
  public ApiResp<Void> handleBusinessException(BusinessException e){
    return ApiResp.<Void>builder()
      .syscode(e.getSysCode())
      .build();
  }

  @ExceptionHandler(HttpClientErrorException.class)
  public ApiResp<Void> handleBusinessException(){
    return ApiResp.<Void>builder()
      .syscode(SysCode.RestTemplate_Error)
      .build();
  }
}
