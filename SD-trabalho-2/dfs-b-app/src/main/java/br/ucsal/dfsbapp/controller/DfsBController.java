package br.ucsal.dfsbapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.dfsbapp.services.*;
import br.ucsal.dfsbapp.viewmodels.*;

@RestController
public class DfsBController {

    private IFileService fileService;

    public DfsBController(IFileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/health")
    public String healthy() {
        return "Dfs B app rodando.";
    }

    @PostMapping("/salvarArquivo")
    public ResponseEntity<?> saveFile(@RequestBody SaveFileRequestDTO dto) {
        var response = fileService.saveFile(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/obterArquivo")
    public ResponseEntity<?> getFile(@RequestBody GetFileRequestDTO dto) {
        var response = fileService.getFile(dto);
        return ResponseEntity.ok(response);
    }
}