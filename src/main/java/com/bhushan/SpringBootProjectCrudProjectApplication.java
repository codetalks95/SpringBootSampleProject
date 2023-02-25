package com.bhushan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee API's", version = "2.0", description = "Employee API's Information"))
public class SpringBootProjectCrudProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectCrudProjectApplication.class, args);
    }

}
