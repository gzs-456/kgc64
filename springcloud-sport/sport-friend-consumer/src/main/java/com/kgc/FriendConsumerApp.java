package com.kgc;

import com.kgc.config.FriendUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
public class FriendConsumerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FriendConsumerApp.class, args);
        FriendUtil friendUtil=run.getBean(FriendUtil.class);
        try {
            //friendUtil.createIndex();
            //friendUtil.addDoc();
            //friendUtil.deleteIndex();
            //friendUtil.searchpage(0,2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
