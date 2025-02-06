package com.sb2.demo_restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sb2.demo_restful.model.Cat;
import com.sb2.demo_restful.model.CatDatabase;

@Controller
@ResponseBody
public class CatController {
  @PostMapping(value = "/cat")
  public Cat createCat(@RequestBody Cat cat){
    if(CatDatabase.put(cat))
    return cat;
    return null;
  }
}
