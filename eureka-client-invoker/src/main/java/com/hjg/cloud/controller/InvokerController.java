package com.hjg.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/11/9
 */
@RestController
public class InvokerController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 使用http://localhost:8082/router?name=James来访问，可以得到UserController的结果。
     * @param name
     * @return
     */
    @RequestMapping(value = "/router")
    public String router(String name) {
        return restTemplate.getForObject("http://provider/hello?name="+name, String.class);
    }
}
