package com.hjg.replica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication2.class, args);
    }
}
