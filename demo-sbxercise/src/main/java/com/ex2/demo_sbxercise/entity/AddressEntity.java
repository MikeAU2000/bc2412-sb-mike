package com.ex2.demo_sbxercise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Addresses")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class AddressEntity {
  @Id
  private String zipcode;
  private String street;
  private String suite;
  private String city;
  @OneToOne
  @JoinColumn(name = "geo_id")
  private GeoEntity geo;

}
