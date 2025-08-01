package org.example.yeye_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class YeyeBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(YeyeBackEndApplication.class, args);
    }

}
