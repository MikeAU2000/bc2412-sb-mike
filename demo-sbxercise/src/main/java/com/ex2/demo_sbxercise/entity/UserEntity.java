package com.ex2.demo_sbxercise.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class UserEntity {
  @Id
  private Long id;
  private String name;
  private String email;
  private String username;
  @OneToOne
  @JoinColumn(name = "address_zipcode")
  private AddressEntity addressEntity;
  private String phone;
  private String website;
  @ManyToOne
  @JoinColumn(name = "company_id")
  private CompanyEntity CompanyEntity;
}
