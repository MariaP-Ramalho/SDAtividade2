package br.ucsal.perfilapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"br.ucsal.perfilapp"})

public class PerfilAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PerfilAppApplication.class, args);
    }
}