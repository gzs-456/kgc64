package com.kgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SportZuulApp {

    public static void main(String[] args) {
        SpringApplication.run(SportZuulApp.class, args);
    }

}
