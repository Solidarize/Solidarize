package com.solidarize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EntityScan(
        basePackageClasses = { SolidarizeApplication.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class SolidarizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolidarizeApplication.class, args);
    }
}
