package com.company.menumaker.config;

import com.company.menumaker.mapper.MenuMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuMapperConfig {

    @Bean
    public MenuMapper menuMapper(){
        return MenuMapper.INSTANCE;
    }
}
