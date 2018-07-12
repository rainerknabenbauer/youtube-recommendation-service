package de.basedefender.youtube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class YtScraperRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(YtScraperRestApplication.class);
    }
}
