package com.ippikioukami.acftbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ippikioukami.acftbackend.Controller"})
public class AcftBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcftBackendApplication.class, args);
    }
}
