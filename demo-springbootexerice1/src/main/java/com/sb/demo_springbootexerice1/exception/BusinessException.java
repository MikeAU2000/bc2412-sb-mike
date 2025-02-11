package com.sb.demo_springbootexerice1.exception;

public class BusinessException extends RuntimeException{
  public BusinessException(String message){
    super(message);
  }
}
