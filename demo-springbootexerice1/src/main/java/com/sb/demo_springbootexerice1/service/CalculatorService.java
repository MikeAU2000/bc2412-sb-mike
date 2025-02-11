package com.sb.demo_springbootexerice1.service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.sb.demo_springbootexerice1.database.Calculator;
import com.sb.demo_springbootexerice1.database.CalculatorAnswer;
import com.sb.demo_springbootexerice1.exception.BusinessException;

@Service
public class CalculatorService {
  public CalculatorAnswer operate(Calculator calculator){
    Double x=Double.valueOf(calculator.getX());
    Double y=Double.valueOf(calculator.getY());
    String operation= calculator.getOperation();
    Double result= switch(operation){
      case "add" -> sum(x, y);
      case "sub" -> subtract(x,y);
      case "mul" -> multiply(x,y);
      case "div" -> divide(x,y);
      default -> throw new IllegalArgumentException("Invalid operation: " + operation);
    };
    return new CalculatorAnswer(String.valueOf(x), String.valueOf(y), operation, String.valueOf(result));
  }

  private Double sum(Double x, Double y) {
    return x + y;
  }

  private Double subtract(Double x, Double y) {
    return x - y;
  }

  private Double multiply(Double x, Double y) {
    return x * y;
  }

  private Double divide(Double x, Double y) {
    System.out.println("divide()");
    if (y == 0)
      throw new BusinessException(
          "CalculatorService.divide() / zero." + "x=" + x + ",y=" + y);
    return BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y),5,RoundingMode.HALF_UP).doubleValue();
  }
}
