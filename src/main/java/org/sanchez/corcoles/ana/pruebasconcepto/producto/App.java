package org.sanchez.corcoles.ana.pruebasconcepto.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"org.sanchez.corcoles.ana.pruebasconcepto.commons.model.entity"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
