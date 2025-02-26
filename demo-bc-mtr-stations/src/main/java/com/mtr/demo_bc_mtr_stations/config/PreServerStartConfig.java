package com.mtr.demo_bc_mtr_stations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.mtr.demo_bc_mtr_stations.config.initialization.LineServiceImpl;
import com.mtr.demo_bc_mtr_stations.config.initialization.StationServiceImpl;
import com.mtr.demo_bc_mtr_stations.repository.LineRepository;
import com.mtr.demo_bc_mtr_stations.repository.StationRepository;

@Component
public class PreServerStartConfig implements CommandLineRunner {
  @Autowired
  private LineServiceImpl lineServiceImpl;
  @Autowired
  private StationServiceImpl stationServiceImpl;
  @Autowired
  private LineRepository lineRepository;
  @Autowired
  private StationRepository stationRepository;

  @Override
  public void run(String... args) throws Exception {
    if (lineRepository.count() == 0 && stationRepository.count() == 0) {
      stationServiceImpl.initializeStations();
      lineServiceImpl.initializeLines();
    }
  }

}
