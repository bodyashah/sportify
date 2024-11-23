package com.bodyashah.userservice.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bodyashah.userservice")
public class UserServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
