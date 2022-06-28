package com.company.menumaker.dto;

import com.company.menumaker.entities.Restaurant;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDtoConverter {
    public RestaurantDto converter(Restaurant restaurant){
      return RestaurantDto.builder()
              .id(restaurant.getId())
              .phone(restaurant.getPhone())
              .email(restaurant.getEmail())
              .address(restaurant.getAddress())
              .image(restaurant.getImage())
              .name(restaurant.getName())
              .userId(restaurant.getUserId())
              .qrCode(restaurant.getQrCode())
              .state(restaurant.getState())
              .build();
    }
}
