package com.mtr.demo_bc_mtr_stations.model;

public enum StationId {
  HOK("Hong Kong"), KOW("Kowloon"), TSY("Tsing Yi"), AIR("Airport"), AWE(
      "AsiaWorld Expo"), OLY("Olympic"), NAC("Nam Cheong"), LAK(
          "Lai King"), SUN("Sunny Bay"), TUC("Tung Chung"), WKS(
              "Wu Kai Sha"), MOS("Ma On Shan"), HEO("Heng On"), TSH(
                  "Tai Shui Hang"), SHM("Shek Mun"), CIO("City One"), STW(
                      "Sha Tin Wai"), CKT("Che Kung Temple"), TAW(
                          "Tai Wai"), HIK("Hin Keng"), DIH("Diamond Hill"), KAT(
                              "Kai Tak"), SUW("Sung Wong Toi"), TKW(
                                  "To Kwa Wan"), HOM("Ho Man Tin"), HUH(
                                      "Hung Hom"), ETS(
                                          "East Tsim Sha Tsui"), AUS(
                                              "Austin"), MEF("Mei Foo"), TWW(
                                                  "Tsuen Wan West"), KSR(
                                                      "Kam Sheung Road"), YUL(
                                                          "Yuen Long"), LOP(
                                                              "Long Ping"), TIS(
                                                                  "Tin Shui Wai"), SIH(
                                                                      "Siu Hong"), TUM(
                                                                          "Tuen Mun"), NOP(
                                                                              "North Point"), QUB(
                                                                                  "Quarry Bay"), YAT(
                                                                                      "Yau Tong"), TIK(
                                                                                          "Tiu Keng Leng"), TKO(
                                                                                              "Tseung Kwan O"), LHP(
                                                                                                  "LOHAS Park"), HAH(
                                                                                                      "Hang Hau"), POA(
                                                                                                          "Po Lam"), ADM(
                                                                                                              "Admiralty"), EXC(
                                                                                                                  "Exhibition Centre"), MKK(
                                                                                                                      "Mong Kok East"), KOT(
                                                                                                                          "Kowloon Tong"), SHT(
                                                                                                                              "Sha Tin"), FOT(
                                                                                                                                  "Fo Tan"), RAC(
                                                                                                                                      "Racecourse"), UNI(
                                                                                                                                          "University"), TAP(
                                                                                                                                              "Tai Po Market"), TWO(
                                                                                                                                                  "Tai Wo"), FAN(
                                                                                                                                                      "Fanling"), SHS(
                                                                                                                                                          "Sheung Shui"), LOW(
                                                                                                                                                              "Lo Wu"), LMC(
                                                                                                                                                                  "Lok Ma Chau"), OCP(
                                                                                                                                                                      "Ocean Park"), WCH(
                                                                                                                                                                          "Wong Chuk Hang"), LET(
                                                                                                                                                                              "Lei Tung"), SOH(
                                                                                                                                                                                  "South Horizons"), TST(
                                                                                                                                                                                      "Tsim Sha Tsui"), JOR(
                                                                                                                                                                                          "Jordan"), SSP(
                                                                                                                                                                                              "Sham Shui Po"), CSW(
                                                                                                                                                                                                  "Cheung Sha Wan"), LCK(
                                                                                                                                                                                                      "Lai Chi Kok"), KWF(
                                                                                                                                                                                                          "Kwai Fong"), KWH(
                                                                                                                                                                                                              "Kwai Hing"), TWH(
                                                                                                                                                                                                                  "Tai Wo Hau"), TSW(
                                                                                                                                                                                                                      "Tsuen Wan"),


  KET("Kennedy Town"), HKU("HKU"), SYP("Sai Ying Pun"), SHW("Sheung Wan"), CEN(
      "Central"), WAC("Wan Chai"), CAB("Causeway Bay"), TIH("Tin Hau"), FOH(
          "Fortress Hill"), TAK("Tai Koo"), SWH("Sai Wan Ho"), SKW(
              "Shau Kei Wan"), HFC("Heng Fa Chuen"), CHW("Chai Wan"),

  WHA("Whampoa"), YMT("Yau Ma Tei"), MOK("Mong Kok"), PRE("Prince Edward"), SKM(
      "Shek Kip Mei"), LOF("Lok Fu"), WTS("Wong Tai Sin"), CHH(
          "Choi Hung"), KOB("Kowloon Bay"), NTK(
              "Ngau Tau Kok"), KWT("Kwun Tong"), LAT("Lam Tin"),;



  private final String description;

  StationId(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
