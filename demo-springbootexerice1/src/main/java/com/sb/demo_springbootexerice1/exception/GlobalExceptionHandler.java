package com.sb.demo_springbootexerice1.exception;
import java.net.http.HttpClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.sb.demo_springbootexerice1.model.ErrorResult;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(
    value={ArithmeticException.class, BusinessException.class}
  )@ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResult handleArithmetic(RuntimeException e){
    return new ErrorResult(e.getMessage());
  }

  @ExceptionHandler(value = VincentException.class)
  @ResponseStatus(value= HttpStatus.BAD_REQUEST)
  public ErrorResult handleVincentException(VincentException e){
    return new ErrorResult(e.getMessage());
  }
}
