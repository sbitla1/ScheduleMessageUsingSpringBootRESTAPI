package com.sbitla1.springboot.schedulemessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootScheduleMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootScheduleMessageApplication.class, args);
    }

}