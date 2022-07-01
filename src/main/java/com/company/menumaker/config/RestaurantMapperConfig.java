package com.company.menumaker.config;

import com.company.menumaker.mapper.RestaurantMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantMapperConfig {

    @Bean
    public RestaurantMapper restaurantMapper(){
        return RestaurantMapper.INSTANCE;
    }
}
