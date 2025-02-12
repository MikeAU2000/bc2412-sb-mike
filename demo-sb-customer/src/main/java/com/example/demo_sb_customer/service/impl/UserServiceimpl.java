package com.example.demo_sb_customer.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.demo_sb_customer.entity.AddressEntity;
import com.example.demo_sb_customer.entity.CompanyEntity;
import com.example.demo_sb_customer.entity.GeoEntity;
import com.example.demo_sb_customer.entity.UserEntity;
import com.example.demo_sb_customer.entity.mapper.EntityMapper;
import com.example.demo_sb_customer.model.dto.UserDto;
import com.example.demo_sb_customer.repository.AddressRepository;
import com.example.demo_sb_customer.repository.CompanyRepository;
import com.example.demo_sb_customer.repository.GeoRepository;
import com.example.demo_sb_customer.repository.UserRepository;
import com.example.demo_sb_customer.service.UserService;

@Service
public class UserServiceimpl implements UserService{
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private GeoRepository geoRepository;

  @Autowired
  private EntityMapper entityMapper;

  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.users}")
  private String usersEndpoint;

  // @Override
  // public List<UserDto> getUsers() {
  //   String url=  "https://jsonplaceholder.typicode.com/users";
  //   return Arrays.asList(this.restTemplate.getForObject(url, UserDto[].class));
  // }

  @Override 
  public List<UserDto> getUsers(){
    String url =UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(usersEndpoint)
      .build()
      .toUriString();
    
      List<UserDto> userDtos=
        Arrays.asList(this.restTemplate.getForObject(url,UserDto[].class));
      this.geoRepository.deleteAll();
      this.addressRepository.deleteAll();
      this.companyRepository.deleteAll();
      this.userRepository.deleteAll();

      userDtos.stream().forEach(e->{
        UserEntity userEntity= this.userRepository.save(this.entityMapper.map(e));

        AddressEntity addressEntity = this.entityMapper.map(e.getAddress());
        addressEntity.setUserEntity(userEntity);
        this.addressRepository.save(addressEntity);

        CompanyEntity companyEntity = this.entityMapper.map(e.getCompany());
        companyEntity.setUserEntity(userEntity);
        this.companyRepository.save(companyEntity);

        GeoEntity geoEntity = this.entityMapper.map(e.getAddress().getGeo());
        geoEntity.setAddressEntity(addressEntity);
        this.geoRepository.save(geoEntity);
      }
      );

      return userDtos;
  }
  
}
