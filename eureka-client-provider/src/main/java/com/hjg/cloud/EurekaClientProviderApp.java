package com.hjg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/3/25
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProviderApp.class, args);
    }
}
