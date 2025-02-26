package com.ex2.demo_sbxercise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ex2.demo_sbxercise.service.UpcSservice;

@Component
public class PreserverStartConfig implements CommandLineRunner{
  @Autowired
  private UpcSservice upcSservice;

  @Override
  public void run(String... args) throws Exception {
    upcSservice.saveAllUsersEntity();
      upcSservice.saveAllPostEntity();
      upcSservice.saveAllCommentEntity();
  }
}
