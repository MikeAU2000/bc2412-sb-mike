package com.mtr.demo_bc_mtr_stations.entity;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import com.mtr.demo_bc_mtr_stations.model.LineId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "line")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LineEntity {
  @Id
  @Enumerated(EnumType.STRING)
  private LineId lineId;

  @ManyToMany
  @JoinTable(name = "line_station", joinColumns = @JoinColumn(name = "line_id"),
      inverseJoinColumns = @JoinColumn(name = "station_id"))
  @JsonIgnore
  private Set<StationEntity> stations;

  public List<StationEntity> getStationsList() {
    return new ArrayList<>(stations);
}
}
