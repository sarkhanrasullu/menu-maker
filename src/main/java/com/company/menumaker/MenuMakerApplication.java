package com.company.menumaker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "menu-maker Service API",
                description = "menu-maker crud services",
                version = "v1"
        )
)
@SpringBootApplication
public class MenuMakerApplication {

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Hello 2");
        System.out.println("1");
        System.out.println("2");
        SpringApplication.run(MenuMakerApplication.class, args);
    }

}
