package br.ucsal.dfsmasterapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"br.ucsal.dfsmasterapp"})
public class DfsMasterAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfsMasterAppApplication.class, args);
    }

}
