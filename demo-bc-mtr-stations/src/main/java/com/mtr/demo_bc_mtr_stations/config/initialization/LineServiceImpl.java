package com.mtr.demo_bc_mtr_stations.config.initialization;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtr.demo_bc_mtr_stations.entity.LineEntity;
import com.mtr.demo_bc_mtr_stations.entity.StationEntity;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import com.mtr.demo_bc_mtr_stations.model.StationId;
import com.mtr.demo_bc_mtr_stations.repository.LineRepository;
import jakarta.transaction.Transactional;

@Service
public class LineServiceImpl{
  @Autowired
  private LineRepository lineRepository;


  @Transactional
  public void initializeLines() {
    Set<StationEntity> aelStations= new HashSet<>();
    aelStations.add(StationEntity.builder().station_id(StationId.HOK).build());
    aelStations.add(StationEntity.builder().station_id(StationId.KOW).build());
    aelStations.add(StationEntity.builder().station_id(StationId.TSY).build());
    aelStations.add(StationEntity.builder().station_id(StationId.AIR).build());
    aelStations.add(StationEntity.builder().station_id(StationId.AWE).build());

    lineRepository.save(LineEntity.builder().lineId(LineId.AEL).stations(aelStations).build());

    Set<StationEntity> tclStations= new HashSet<>();
    tclStations.add(StationEntity.builder().station_id(StationId.HOK).build());
    tclStations.add(StationEntity.builder().station_id(StationId.KOW).build());
    tclStations.add(StationEntity.builder().station_id(StationId.OLY).build());
    tclStations.add(StationEntity.builder().station_id(StationId.NAC).build());
    tclStations.add(StationEntity.builder().station_id(StationId.LAK).build());
    tclStations.add(StationEntity.builder().station_id(StationId.TSY).build());
    tclStations.add(StationEntity.builder().station_id(StationId.SUN).build());
    tclStations.add(StationEntity.builder().station_id(StationId.TUC).build());

    lineRepository.save(LineEntity.builder().lineId(LineId.TCL).stations(tclStations).build());

    Set<StationEntity> tmlStations = new HashSet<>();
    tmlStations.add(StationEntity.builder().station_id(StationId.WKS).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.MOS).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.HEO).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.TSH).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.SHM).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.CIO).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.STW).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.CKT).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.TAW).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.HIK).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.DIH).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.KAT).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.SUW).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.TKW).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.HOM).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.HUH).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.ETS).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.AUS).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.NAC).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.MEF).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.TWW).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.KSR).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.YUL).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.LOP).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.TIS).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.SIH).build());
    tmlStations.add(StationEntity.builder().station_id(StationId.TUM).build());

    lineRepository.save(LineEntity.builder().lineId(LineId.TML).stations(tmlStations).build());

    Set<StationEntity> tklStations = new HashSet<>();
    tklStations.add(StationEntity.builder().station_id(StationId.NOP).build());
    tklStations.add(StationEntity.builder().station_id(StationId.QUB).build());
    tklStations.add(StationEntity.builder().station_id(StationId.YAT).build());
    tklStations.add(StationEntity.builder().station_id(StationId.TIK).build());
    tklStations.add(StationEntity.builder().station_id(StationId.TKO).build());
    tklStations.add(StationEntity.builder().station_id(StationId.LHP).build());
    tklStations.add(StationEntity.builder().station_id(StationId.HAH).build());
    tklStations.add(StationEntity.builder().station_id(StationId.POA).build());

    lineRepository.save(LineEntity.builder().lineId(LineId.TKL).stations(tklStations).build());

    Set<StationEntity> ealStations = new HashSet<>();
    ealStations.add(StationEntity.builder().station_id(StationId.ADM).build());
    ealStations.add(StationEntity.builder().station_id(StationId.EXC).build());
    ealStations.add(StationEntity.builder().station_id(StationId.HUH).build());
    ealStations.add(StationEntity.builder().station_id(StationId.MKK).build());
    ealStations.add(StationEntity.builder().station_id(StationId.KOT).build());
    ealStations.add(StationEntity.builder().station_id(StationId.TAW).build());
    ealStations.add(StationEntity.builder().station_id(StationId.SHT).build());
    ealStations.add(StationEntity.builder().station_id(StationId.FOT).build());
    ealStations.add(StationEntity.builder().station_id(StationId.RAC).build());
    ealStations.add(StationEntity.builder().station_id(StationId.UNI).build());
    ealStations.add(StationEntity.builder().station_id(StationId.TAP).build());
    ealStations.add(StationEntity.builder().station_id(StationId.TWO).build());
    ealStations.add(StationEntity.builder().station_id(StationId.FAN).build());
    ealStations.add(StationEntity.builder().station_id(StationId.SHS).build());
    ealStations.add(StationEntity.builder().station_id(StationId.LOW).build());
    ealStations.add(StationEntity.builder().station_id(StationId.LMC).build());

    lineRepository.save(LineEntity.builder().lineId(LineId.EAL).stations(ealStations).build());

    Set<StationEntity> silStations = new HashSet<>();
    silStations.add(StationEntity.builder().station_id(StationId.ADM).build());
    silStations.add(StationEntity.builder().station_id(StationId.OCP).build());
    silStations.add(StationEntity.builder().station_id(StationId.WCH).build());
    silStations.add(StationEntity.builder().station_id(StationId.LET).build());
    silStations.add(StationEntity.builder().station_id(StationId.SOH).build());
    
    lineRepository.save(LineEntity.builder().lineId(LineId.SIL).stations(silStations).build());

    Set<StationEntity> twlStations = new HashSet<>();
    twlStations.add(StationEntity.builder().station_id(StationId.CEN).build());
    twlStations.add(StationEntity.builder().station_id(StationId.ADM).build());
    twlStations.add(StationEntity.builder().station_id(StationId.TST).build());
    twlStations.add(StationEntity.builder().station_id(StationId.JOR).build());
    twlStations.add(StationEntity.builder().station_id(StationId.YMT).build());
    twlStations.add(StationEntity.builder().station_id(StationId.MOK).build());
    twlStations.add(StationEntity.builder().station_id(StationId.PRE).build());
    twlStations.add(StationEntity.builder().station_id(StationId.SSP).build());
    twlStations.add(StationEntity.builder().station_id(StationId.CSW).build());
    twlStations.add(StationEntity.builder().station_id(StationId.LCK).build());
    twlStations.add(StationEntity.builder().station_id(StationId.MEF).build());
    twlStations.add(StationEntity.builder().station_id(StationId.LAK).build());
    twlStations.add(StationEntity.builder().station_id(StationId.KWF).build());
    twlStations.add(StationEntity.builder().station_id(StationId.KWH).build());
    twlStations.add(StationEntity.builder().station_id(StationId.TWH).build());
    twlStations.add(StationEntity.builder().station_id(StationId.TSW).build());

    lineRepository.save(LineEntity.builder().lineId(LineId.TWL).stations(twlStations).build());

    Set<StationEntity> islStations = new HashSet<>();
    islStations.add(StationEntity.builder().station_id(StationId.KET).build());
    islStations.add(StationEntity.builder().station_id(StationId.HKU).build());
    islStations.add(StationEntity.builder().station_id(StationId.SYP).build());
    islStations.add(StationEntity.builder().station_id(StationId.SHW).build());
    islStations.add(StationEntity.builder().station_id(StationId.CEN).build());
    islStations.add(StationEntity.builder().station_id(StationId.ADM).build());
    islStations.add(StationEntity.builder().station_id(StationId.WAC).build());
    islStations.add(StationEntity.builder().station_id(StationId.CAB).build());
    islStations.add(StationEntity.builder().station_id(StationId.TIH).build());
    islStations.add(StationEntity.builder().station_id(StationId.FOH).build());
    islStations.add(StationEntity.builder().station_id(StationId.NOP).build());
    islStations.add(StationEntity.builder().station_id(StationId.QUB).build());
    islStations.add(StationEntity.builder().station_id(StationId.TAK).build());
    islStations.add(StationEntity.builder().station_id(StationId.SWH).build());
    islStations.add(StationEntity.builder().station_id(StationId.SKW).build());
    islStations.add(StationEntity.builder().station_id(StationId.HFC).build());
    islStations.add(StationEntity.builder().station_id(StationId.CHW).build());

    lineRepository.save(LineEntity.builder().lineId(LineId.ISL).stations(islStations).build());

    Set<StationEntity> ktlStations = new HashSet<>();
    ktlStations.add(StationEntity.builder().station_id(StationId.WHA).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.HOM).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.YMT).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.MOK).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.PRE).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.SKM).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.KOT).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.LOF).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.WTS).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.DIH).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.CHH).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.KOB).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.NTK).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.KWT).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.LAT).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.YAT).build());
    ktlStations.add(StationEntity.builder().station_id(StationId.TIK).build());

    lineRepository.save(LineEntity.builder().lineId(LineId.KTL).stations(ktlStations).build());
    }
  
}
