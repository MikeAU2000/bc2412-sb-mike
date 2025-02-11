package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;

  @Getter
  @Setter
  @AllArgsConstructor
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Geo {
      @JsonProperty(value = "x")
      private String latitude;
      @JsonProperty(value = "y")
      private String longitude;
    }
  }
}
