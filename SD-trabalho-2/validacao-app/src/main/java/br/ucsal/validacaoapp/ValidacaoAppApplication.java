package br.ucsal.validacaoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"br.ucsal.validacaoapp"})
public class ValidacaoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidacaoAppApplication.class, args);
    }

}
