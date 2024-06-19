package br.ucsal.dfsaapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.dfsaapp.viewmodels.*;

@RestController
public class DfsAController {

    @GetMapping("/health")
    public String healthy() {
        return "Dfs A app rodando.";
    }

    @PostMapping("/salvarArquivo")
    public ResponseEntity<?> saveFile(@RequestBody SaveFileRequestDTO dto) {
        return ResponseEntity.ok("Chegou no App A (file: "+dto.getFile().getName()+" / fileName: "+dto.getFileName()+")");
    }
}
