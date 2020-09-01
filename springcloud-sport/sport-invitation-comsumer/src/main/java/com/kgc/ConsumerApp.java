package com.kgc;

import com.kgc.config.InvitationUtil;
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
public class ConsumerApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(ConsumerApp.class, args);
        InvitationUtil invitationUtil=run.getBean(InvitationUtil.class);
        try {
            //invitationUtil.createIndex();
            //invitationUtil.addDoc();
            //invitationUtil.deleteIndex();
            //invitationUtil.fetchSource();
            //invitationUtil.searchpage(0,2);
            //invitationUtil.getDoc();
            //invitationUtil.highQuery();
            //invitationUtil.termQuery();
            //invitationUtil.matchquery();
            //invitationUtil.multiQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
