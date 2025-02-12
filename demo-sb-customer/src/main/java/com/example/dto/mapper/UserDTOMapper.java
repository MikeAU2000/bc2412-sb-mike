package com.example.dto.mapper;

import org.springframework.stereotype.Component;
import com.example.demo_sb_customer.model.dto.UserDto;
import com.example.dto.UserDTO;

@Component
public class UserDTOMapper {
  public UserDTO map(UserDto dto) {
    return new UserDTO(dto.getId(), dto.getName(), dto.getUsername(),
        dto.getEmail(),
        new UserDTO.Address(dto.getAddress().getStreet(),
            dto.getAddress().getSuite(), dto.getAddress().getCity(),
            dto.getAddress().getZipcode(),
            new UserDTO.Address.Geo(dto.getAddress().getGeo().getLatitude(),
                dto.getAddress().getGeo().getLongitude())));

  }
}
