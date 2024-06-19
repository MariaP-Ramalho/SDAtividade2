package br.ucsal.dfsmasterapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.ucsal.dfsmasterapp.viewmodels.*;

@RestController
public class DfsMasterController {
   
    private List<String> dfUrl = new ArrayList<String>();
    private final RestTemplate restTemplate;
    private Random rd;

    public DfsMasterController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        dfUrl.add("http://dfs-a-app:8184");
        dfUrl.add("http://dfs-b-app:8185");
        rd = new Random();
    }

    @GetMapping("/health")
    public String healthy() {
        return "Dfs Master app rodando.";
    }

    @PostMapping("/salvarArquivo")
    public ResponseEntity<?> saveFile(@RequestBody SaveFileRequestDTO dto) {
        
        var url = getRandomUrl();
        url += "/salvarArquivo";
        System.out.println("[DFS-MASTER][REDIRECTING] to target URL: " + url);
        var responseEntity = restTemplate.postForObject(url, dto, String.class);
        return ResponseEntity.ok(responseEntity);
    }

    private String getRandomUrl() {
        var randomUrlPosition = rd.nextInt(dfUrl.size());
        return dfUrl.get(randomUrlPosition);
    }
}
