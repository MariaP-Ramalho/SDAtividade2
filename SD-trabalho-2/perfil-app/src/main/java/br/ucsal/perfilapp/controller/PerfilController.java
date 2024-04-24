package br.ucsal.perfilapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PerfilController {

    @GetMapping("/health")
    public String healthy() {
        return "Perfil app rodando.";
    }
    
    @PostMapping("/perfil")
    public String healthy(@RequestBody String payload) {
        return "Perfil Acessado ";
    }
}
