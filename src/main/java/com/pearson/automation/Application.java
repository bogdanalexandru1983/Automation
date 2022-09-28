package com.pearson.automation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.pearson.automation"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        log.info("Starting the application");
        SpringApplication.run(Application.class,args);

    }
}
