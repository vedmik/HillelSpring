package com.example.hillelspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HillelSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HillelSpringApplication.class, args);
    }

}
