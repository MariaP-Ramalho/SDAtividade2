package br.ucsal.validacaoapp.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ValidacaoController {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @GetMapping("/health")
    public String healthy() {
        return "Validação Acessada";
    }

}
