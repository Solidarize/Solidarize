package com.solidarize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.solidarize.**")
public class SolidarizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolidarizeApplication.class, args);
    }


}
