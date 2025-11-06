package com.walletwave.jwtlogintemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootJwtLoginTemplateApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootJwtLoginTemplateApplication.class, args);
    }

}
