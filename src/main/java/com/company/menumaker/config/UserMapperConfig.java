package com.company.menumaker.config;

import com.company.menumaker.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapperConfig {

    @Bean
    public UserMapper userMapper(){
        return UserMapper.INSTANCE;
    }
}
