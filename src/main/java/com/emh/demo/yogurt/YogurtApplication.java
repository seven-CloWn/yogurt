package com.emh.demo.yogurt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class YogurtApplication {

    public static void main(String[] args) {
        SpringApplication.run(YogurtApplication.class, args);
    }

}
