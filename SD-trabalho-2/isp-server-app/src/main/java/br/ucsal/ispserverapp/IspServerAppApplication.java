package br.ucsal.ispserverapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.ucsal.ispserverapp")
public class IspServerAppApplication {
	public static void main(String[] args) {

		SpringApplication.run(IspServerAppApplication.class, args);
	}
}

