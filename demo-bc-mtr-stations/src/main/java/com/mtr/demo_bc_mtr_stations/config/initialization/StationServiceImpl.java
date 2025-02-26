package com.mtr.demo_bc_mtr_stations.config.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtr.demo_bc_mtr_stations.entity.StationEntity;
import com.mtr.demo_bc_mtr_stations.model.StationId;
import com.mtr.demo_bc_mtr_stations.repository.StationRepository;

@Service
public class StationServiceImpl{
        @Autowired
        private StationRepository stationRepository;

        public void initializeStations() {
                StationEntity hok = StationEntity.builder()
                                .station_id(StationId.HOK).build();
                StationEntity kow = StationEntity.builder()
                                .station_id(StationId.KOW).build();
                StationEntity tsy = StationEntity.builder()
                                .station_id(StationId.TSY).build();
                StationEntity air = StationEntity.builder()
                                .station_id(StationId.AIR).build();
                StationEntity awe = StationEntity.builder()
                                .station_id(StationId.AWE).build();

                stationRepository.save(hok);
                stationRepository.save(kow);
                stationRepository.save(tsy);
                stationRepository.save(air);
                stationRepository.save(awe);

                // StationEntity hok = StationEntity.builder().station_id(StationId.HOK).build();
                // StationEntity kow = StationEntity.builder().station_id(StationId.KOW).build();
                StationEntity oly = StationEntity.builder()
                                .station_id(StationId.OLY).build();
                StationEntity nac = StationEntity.builder()
                                .station_id(StationId.NAC).build();
                StationEntity lak = StationEntity.builder()
                                .station_id(StationId.LAK).build();
                StationEntity tsk = StationEntity.builder()
                                .station_id(StationId.TSY).build();
                StationEntity sun = StationEntity.builder()
                                .station_id(StationId.SUN).build();
                StationEntity tuc = StationEntity.builder()
                                .station_id(StationId.TUC).build();

                stationRepository.save(oly);
                stationRepository.save(nac);
                stationRepository.save(lak);
                stationRepository.save(tsk);
                stationRepository.save(sun);
                stationRepository.save(tuc);

                // 屯马线车站
                StationEntity wks = StationEntity.builder()
                                .station_id(StationId.WKS).build();
                StationEntity mos = StationEntity.builder()
                                .station_id(StationId.MOS).build();
                StationEntity heo = StationEntity.builder()
                                .station_id(StationId.HEO).build();
                StationEntity tsh = StationEntity.builder()
                                .station_id(StationId.TSH).build();
                StationEntity shm = StationEntity.builder()
                                .station_id(StationId.SHM).build();
                StationEntity cio = StationEntity.builder()
                                .station_id(StationId.CIO).build();
                StationEntity stw = StationEntity.builder()
                                .station_id(StationId.STW).build();
                StationEntity ckt = StationEntity.builder()
                                .station_id(StationId.CKT).build();
                StationEntity taw = StationEntity.builder()
                                .station_id(StationId.TAW).build();
                StationEntity hik = StationEntity.builder()
                                .station_id(StationId.HIK).build();
                StationEntity dih = StationEntity.builder()
                                .station_id(StationId.DIH).build();
                StationEntity kat = StationEntity.builder()
                                .station_id(StationId.KAT).build();
                StationEntity suw = StationEntity.builder()
                                .station_id(StationId.SUW).build();
                StationEntity tkw = StationEntity.builder()
                                .station_id(StationId.TKW).build();
                StationEntity hom = StationEntity.builder()
                                .station_id(StationId.HOM).build();
                StationEntity huh = StationEntity.builder()
                                .station_id(StationId.HUH).build();
                StationEntity ets = StationEntity.builder()
                                .station_id(StationId.ETS).build();
                StationEntity aus = StationEntity.builder()
                                .station_id(StationId.AUS).build();
                // StationEntity nac =
                // StationEntity.builder().station_id(StationId.NAC).build();
                StationEntity mef = StationEntity.builder()
                                .station_id(StationId.MEF).build();
                StationEntity tww = StationEntity.builder()
                                .station_id(StationId.TWW).build();
                StationEntity ksr = StationEntity.builder()
                                .station_id(StationId.KSR).build();
                StationEntity yul = StationEntity.builder()
                                .station_id(StationId.YUL).build();
                StationEntity lop = StationEntity.builder()
                                .station_id(StationId.LOP).build();
                StationEntity tis = StationEntity.builder()
                                .station_id(StationId.TIS).build();
                StationEntity sih = StationEntity.builder()
                                .station_id(StationId.SIH).build();
                StationEntity tum = StationEntity.builder()
                                .station_id(StationId.TUM).build();

                stationRepository.save(wks);
                stationRepository.save(mos);
                stationRepository.save(heo);
                stationRepository.save(tsh);
                stationRepository.save(shm);
                stationRepository.save(cio);
                stationRepository.save(stw);
                stationRepository.save(ckt);
                stationRepository.save(taw);
                stationRepository.save(hik);
                stationRepository.save(dih);
                stationRepository.save(kat);
                stationRepository.save(suw);
                stationRepository.save(tkw);
                stationRepository.save(hom);
                stationRepository.save(huh);
                stationRepository.save(ets);
                stationRepository.save(aus);
                stationRepository.save(nac);
                stationRepository.save(mef);
                stationRepository.save(tww);
                stationRepository.save(ksr);
                stationRepository.save(yul);
                stationRepository.save(lop);
                stationRepository.save(tis);
                stationRepository.save(sih);
                stationRepository.save(tum);


                StationEntity nop = StationEntity.builder()
                                .station_id(StationId.NOP).build();
                StationEntity qub = StationEntity.builder()
                                .station_id(StationId.QUB).build();
                StationEntity yat = StationEntity.builder()
                                .station_id(StationId.YAT).build();
                StationEntity tik = StationEntity.builder()
                                .station_id(StationId.TIK).build();
                StationEntity tko = StationEntity.builder()
                                .station_id(StationId.TKO).build();
                StationEntity lhp = StationEntity.builder()
                                .station_id(StationId.LHP).build();
                StationEntity hah = StationEntity.builder()
                                .station_id(StationId.HAH).build();
                StationEntity poa = StationEntity.builder()
                                .station_id(StationId.POA).build();


                stationRepository.save(nop);
                stationRepository.save(qub);
                stationRepository.save(yat);
                stationRepository.save(tik);
                stationRepository.save(tko);
                stationRepository.save(lhp);
                stationRepository.save(hah);
                stationRepository.save(poa);


                StationEntity adm = StationEntity.builder()
                                .station_id(StationId.ADM).build();
                StationEntity exc = StationEntity.builder()
                                .station_id(StationId.EXC).build();
                StationEntity mkk = StationEntity.builder()
                                .station_id(StationId.MKK).build();
                StationEntity kot = StationEntity.builder()
                                .station_id(StationId.KOT).build();
                StationEntity sht = StationEntity.builder()
                                .station_id(StationId.SHT).build();
                StationEntity fot = StationEntity.builder()
                                .station_id(StationId.FOT).build();
                StationEntity rac = StationEntity.builder()
                                .station_id(StationId.RAC).build();
                StationEntity uni = StationEntity.builder()
                                .station_id(StationId.UNI).build();
                StationEntity tap = StationEntity.builder()
                                .station_id(StationId.TAP).build();
                StationEntity two = StationEntity.builder()
                                .station_id(StationId.TWO).build();
                StationEntity fan = StationEntity.builder()
                                .station_id(StationId.FAN).build();
                StationEntity shs = StationEntity.builder()
                                .station_id(StationId.SHS).build();
                StationEntity low = StationEntity.builder()
                                .station_id(StationId.LOW).build();
                StationEntity lmc = StationEntity.builder()
                                .station_id(StationId.LMC).build();


                stationRepository.save(adm);
                stationRepository.save(exc);
                stationRepository.save(mkk);
                stationRepository.save(kot);
                stationRepository.save(sht);
                stationRepository.save(fot);
                stationRepository.save(rac);
                stationRepository.save(uni);
                stationRepository.save(tap);
                stationRepository.save(two);
                stationRepository.save(fan);
                stationRepository.save(shs);
                stationRepository.save(low);
                stationRepository.save(lmc);

                StationEntity ocp = StationEntity.builder()
                                .station_id(StationId.OCP).build();
                StationEntity wch = StationEntity.builder()
                                .station_id(StationId.WCH).build();
                StationEntity let = StationEntity.builder()
                                .station_id(StationId.LET).build();
                StationEntity son = StationEntity.builder()
                                .station_id(StationId.SOH).build();

                stationRepository.save(ocp);
                stationRepository.save(wch);
                stationRepository.save(let);
                stationRepository.save(son);

                StationEntity cen = StationEntity.builder()
                                .station_id(StationId.CEN).build();
                StationEntity tst = StationEntity.builder()
                                .station_id(StationId.TST).build();
                StationEntity jor = StationEntity.builder()
                                .station_id(StationId.JOR).build();
                StationEntity ymt = StationEntity.builder()
                                .station_id(StationId.YMT).build();
                StationEntity mok = StationEntity.builder()
                                .station_id(StationId.MOK).build();
                StationEntity pre = StationEntity.builder()
                                .station_id(StationId.PRE).build();
                StationEntity ssp = StationEntity.builder()
                                .station_id(StationId.SSP).build();
                StationEntity csw = StationEntity.builder()
                                .station_id(StationId.CSW).build();
                StationEntity lck = StationEntity.builder()
                                .station_id(StationId.LCK).build();
                StationEntity kwf = StationEntity.builder()
                                .station_id(StationId.KWF).build();
                StationEntity kwh = StationEntity.builder()
                                .station_id(StationId.KWH).build();
                StationEntity twh = StationEntity.builder()
                                .station_id(StationId.TWH).build();
                StationEntity tsw = StationEntity.builder()
                                .station_id(StationId.TSW).build();

                stationRepository.save(cen);
                stationRepository.save(tst);
                stationRepository.save(jor);
                stationRepository.save(ymt);
                stationRepository.save(mok);
                stationRepository.save(pre);
                stationRepository.save(ssp);
                stationRepository.save(csw);
                stationRepository.save(lck);
                stationRepository.save(kwf);
                stationRepository.save(kwh);
                stationRepository.save(twh);
                stationRepository.save(tsw);

                StationEntity ket = StationEntity.builder()
                                .station_id(StationId.KET).build();
                StationEntity hku = StationEntity.builder()
                                .station_id(StationId.HKU).build();
                StationEntity syp = StationEntity.builder()
                                .station_id(StationId.SYP).build();
                StationEntity shw = StationEntity.builder()
                                .station_id(StationId.SHW).build();
                StationEntity wac = StationEntity.builder()
                                .station_id(StationId.WAC).build();
                StationEntity cab = StationEntity.builder()
                                .station_id(StationId.CAB).build();
                StationEntity tih = StationEntity.builder()
                                .station_id(StationId.TIH).build();
                StationEntity foh = StationEntity.builder()
                                .station_id(StationId.FOH).build();
                StationEntity tak = StationEntity.builder()
                                .station_id(StationId.TAK).build();
                StationEntity swh = StationEntity.builder()
                                .station_id(StationId.SWH).build();
                StationEntity skw = StationEntity.builder()
                                .station_id(StationId.SKW).build();
                StationEntity hfc = StationEntity.builder()
                                .station_id(StationId.HFC).build();
                StationEntity chw = StationEntity.builder()
                                .station_id(StationId.CHW).build();


                stationRepository.save(ket);
                stationRepository.save(hku);
                stationRepository.save(syp);
                stationRepository.save(shw);
                stationRepository.save(wac);
                stationRepository.save(cab);
                stationRepository.save(tih);
                stationRepository.save(foh);
                stationRepository.save(tak);
                stationRepository.save(swh);
                stationRepository.save(skw);
                stationRepository.save(hfc);
                stationRepository.save(chw);

                StationEntity wha = StationEntity.builder()
                                .station_id(StationId.WHA).build();
                StationEntity skm = StationEntity.builder()
                                .station_id(StationId.SKM).build();
                StationEntity lof = StationEntity.builder()
                                .station_id(StationId.LOF).build();
                StationEntity wts = StationEntity.builder()
                                .station_id(StationId.WTS).build();
                StationEntity chh = StationEntity.builder()
                                .station_id(StationId.CHH).build();
                StationEntity kob = StationEntity.builder()
                                .station_id(StationId.KOB).build();
                StationEntity ntk = StationEntity.builder()
                                .station_id(StationId.NTK).build();
                StationEntity kwt = StationEntity.builder()
                                .station_id(StationId.KWT).build();
                StationEntity lat = StationEntity.builder()
                                .station_id(StationId.LAT).build();

                stationRepository.save(wha);
                stationRepository.save(skm);
                stationRepository.save(lof);
                stationRepository.save(wts);
                stationRepository.save(chh);
                stationRepository.save(kob);
                stationRepository.save(ntk);
                stationRepository.save(kwt);
                stationRepository.save(lat);
        }

}
