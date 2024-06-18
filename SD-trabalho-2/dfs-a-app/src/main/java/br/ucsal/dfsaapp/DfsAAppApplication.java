package br.ucsal.dfsaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"br.ucsal.dfsaapp"})
public class DfsAAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfsAAppApplication.class, args);
    }

}
