package com.hjg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/3/25
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

    //访问http://localhost:8989/mybooks/hello?name=James
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
