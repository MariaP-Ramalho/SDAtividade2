package br.ucsal.dfsbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"br.ucsal.dfsbapp"})
public class DfsBAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfsBAppApplication.class, args);
    }

}
