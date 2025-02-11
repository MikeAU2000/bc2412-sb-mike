package com.sb2.demo_restful.Service;

import java.nio.file.OpenOption;
import org.springframework.cglib.beans.BulkBeanException;
import org.springframework.stereotype.Service;
import com.sb2.demo_restful.exception.BusinessException;
import com.sb2.demo_restful.model.Operation;

@Service 
public class CalculatorService {
  public Integer operate(Operation operation, Integer x, Integer y){
    int result = switch(operation){
      case SUM -> sum(x, y);
      case SUBTRACT -> subtract(x, y);
      case MULTIPLY -> multiply(x, y);
      case DIVIDE -> divide(x, y);};
      
    System.out.println("operate(): result="+ result);
    return result;
  }

  private Integer sum(Integer x, Integer y){
    return x+y;
  }

  private Integer subtract(Integer x, Integer y) {
    return x - y;
  }

  private Integer multiply(Integer x, Integer y) {
    return x * y;
  }

  private Integer divide (Integer x, Integer y){
      System.out.println("divide()");
      if(y==0)
      throw new BusinessException(
        "CalculatorService.divide() / zero." + "x=" + x + ",y=" + y
      );

      return x/y;
  }


}

