package com.nemocompany.onegomanna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OnegoMannaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnegoMannaServerApplication.class, args);
    }

}
