package br.ucsal.perfilapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PerfilAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerfilAppApplication.class, args);
    }

}
