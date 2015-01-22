package com.test.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
    public String hello(String name) {
        logger.debug("{} is passed", name);
        return "helloService " + name;
    }
}
