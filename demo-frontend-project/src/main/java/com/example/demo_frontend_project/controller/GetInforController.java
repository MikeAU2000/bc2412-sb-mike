package com.example.demo_frontend_project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_frontend_project.dto.BitcoinDTO;
import com.example.demo_frontend_project.service.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GetInforController {
  @Autowired
  private ServiceImpl serviceImpl;

  //http://localhost:8100/getInfor
  @GetMapping("/getInfor")
  public List<BitcoinDTO> getInfor() throws JsonProcessingException{
    return serviceImpl.getDto();
  }
}
