package com.kgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ColumnMyProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ColumnMyProviderApp.class, args);
    }
}
