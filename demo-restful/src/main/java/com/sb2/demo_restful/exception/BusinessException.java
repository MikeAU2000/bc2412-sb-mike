package com.sb2.demo_restful.exception;

public class BusinessException extends RuntimeException{
  public BusinessException(String message){
    super(message);
  }
}
