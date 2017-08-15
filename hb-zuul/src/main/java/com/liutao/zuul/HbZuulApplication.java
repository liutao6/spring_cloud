package com.liutao.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringCloudApplication
@EnableZuulProxy
public class HbZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(HbZuulApplication.class, args);
    }
}
