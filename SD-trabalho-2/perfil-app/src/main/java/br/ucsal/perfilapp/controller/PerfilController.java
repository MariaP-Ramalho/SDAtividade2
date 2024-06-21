package br.ucsal.perfilapp.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.ucsal.perfilapp.services.*;
import br.ucsal.perfilapp.viewmodels.*;

@RestController
public class PerfilController {

    private String dfsUrl = "http://dfs-master-app:8183";
    private final RestTemplate restTemplate;
    private final IProfileService service;

    public PerfilController(IProfileService service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }
    
    @GetMapping("/health")
    public String healthy() {
        return "Perfil app rodando.";
    }

    @PostMapping("/perfil")
    public ResponseEntity<?> getProfile(@RequestBody ProfileRequestDTO dto) {
        var responseDTO = service.getUserProfile(dto.getEmail());

        if (responseDTO == null) {
            var errorMessage = new NotFoundResponseDTO("Perfil não encontrado para o email: " + dto.getEmail());
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(errorMessage);
        }

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/salvarArquivo")
    public ResponseEntity<?> saveFile(@RequestBody SaveFileRequestDTO dto) {
        
        var url = dfsUrl + "/salvarArquivo";
        System.out.println("[PERFIL-APP][REDIRECTING] to target URL: " + url);
        var responseEntity = restTemplate.postForObject(url, dto, String.class);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/obterArquivo")
    public ResponseEntity<?> getFile(@RequestBody GetFileRequestDTO dto) {

        var url = dfsUrl + "/obterArquivo";
        System.out.println("[PERFIL-APP][REDIRECTING] to target URL: " + url);
        var responseEntity = restTemplate.postForObject(url, dto, GetFileResponseDTO.class);
        return ResponseEntity.ok(responseEntity);
    }

}