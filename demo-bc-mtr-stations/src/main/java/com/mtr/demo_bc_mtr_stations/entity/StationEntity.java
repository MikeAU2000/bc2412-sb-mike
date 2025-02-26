package com.mtr.demo_bc_mtr_stations.entity;

import java.util.Set;
import com.mtr.demo_bc_mtr_stations.model.StationId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Stations")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StationEntity {
  @Id
  @Enumerated(EnumType.STRING)
  private StationId station_id;

  @ManyToMany(mappedBy = "stations")
  @JsonIgnore
  private Set<LineEntity> lines;

}
