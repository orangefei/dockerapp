package com.codinglab.hellodocker.dockerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DockerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerAppApplication.class, args);
    }

}
