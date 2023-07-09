package com.lgl.lglclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LglClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(LglClientApplication.class, args);
    }

}
