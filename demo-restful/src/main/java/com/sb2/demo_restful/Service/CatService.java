package com.sb2.demo_restful.Service;

import org.springframework.stereotype.Service;
import com.sb2.demo_restful.model.Cat;
import com.sb2.demo_restful.model.CatDatabase;


  @Service
public class CatService {
  // stateless object, can be a bean
  public boolean put(Cat cat) {
    for (int i = 0; i < CatDatabase.HOME.length; i++) {
      if (CatDatabase.HOME[i] == null) {
        CatDatabase.HOME[i] = cat;
        return true;
      }
    }
    return false;
  }
}

