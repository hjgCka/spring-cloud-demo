package com.hjg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/3/25
 */
@RestController
@SpringBootApplication
public class GatewayApp {

    /**
     * 以代码的方式定义路由，还可以在yml配置文件中定义路由。
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        predicateSpec -> predicateSpec.path("/return/book")
                                .filters(f -> f.addRequestHeader("hello", "world").prefixPath("/cka"))
                                .uri("http://localhost:8081")
                ).build();
    }

    //访问http://localhost:8001/return/book
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }
}
