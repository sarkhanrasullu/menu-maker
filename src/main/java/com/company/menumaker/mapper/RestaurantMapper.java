package com.company.menumaker.mapper;

import com.company.menumaker.dto.RestaurantDto;
import com.company.menumaker.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto restaurantEntityToDto(Restaurant restaurant);

    Restaurant dtoToRestaurantEntity(RestaurantDto restaurantDto);

    List<RestaurantDto> toDtoList(List<Restaurant> restaurants);


}
