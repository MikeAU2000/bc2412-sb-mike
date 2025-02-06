package com.sb.demo_springboot;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloworldConstroller {
  @GetMapping(value="/greeting")
  public Integer num(){
    return 3;
  }

  @GetMapping(value="/greeting1")
  public List<String> hello(){
    List<String> strlist= new ArrayList<>();
    strlist.add("b");
    strlist.add("h");
    return strlist;
  }

  
  
  
}
