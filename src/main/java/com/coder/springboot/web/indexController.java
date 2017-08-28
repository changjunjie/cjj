package com.coder.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changjunjie
 * @since 28.08.2017
 */
@RestController
public class indexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping
    public String NoMapping() {
        return "no mapping path";
    }

}
