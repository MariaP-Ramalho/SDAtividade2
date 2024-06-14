package br.ucsal.dfsaapp.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DfsAController {

    @GetMapping("/health")
    public String healthy() {
        return "Dfs A app rodando.";
    }
}
