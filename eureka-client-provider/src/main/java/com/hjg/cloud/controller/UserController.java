package com.hjg.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/3/25
 */
@RestController
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        logger.info("进入hello方法");
        return "hello " + name;
    }
}
