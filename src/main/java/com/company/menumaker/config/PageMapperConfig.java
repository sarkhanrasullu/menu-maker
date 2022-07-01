package com.company.menumaker.config;

import com.company.menumaker.mapper.PageMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageMapperConfig {

    @Bean
    public PageMapper pageMapper() {
        return PageMapper.INSTANCE;
    }
}
