package com.kgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class Mysleuth {

    public static void main(String[] args) {
        SpringApplication.run(Mysleuth.class, args);
    }
//23

}
