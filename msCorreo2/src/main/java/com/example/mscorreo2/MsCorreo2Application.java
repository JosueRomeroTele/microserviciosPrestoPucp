package com.example.mscorreo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsCorreo2Application {

    public static void main(String[] args) {
        SpringApplication.run(MsCorreo2Application.class, args);
    }

}
