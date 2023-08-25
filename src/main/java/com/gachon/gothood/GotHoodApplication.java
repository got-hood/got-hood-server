package com.gachon.gothood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GotHoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(GotHoodApplication.class, args);
    }

}
