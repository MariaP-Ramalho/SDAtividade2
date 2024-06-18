package br.ucsal.ispserverapp.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ucsal.ispserverapp.viewmodels.ProfileRequestDTO;
import br.ucsal.ispserverapp.viewmodels.ProfileResponseDTO;
import br.ucsal.ispserverapp.viewmodels.ValidacaoRequestDTO;
import br.ucsal.ispserverapp.viewmodels.ValidacaoResponseDTO;

@RestController
public class IspServerController {

    private final RestTemplate restTemplate;
    private final String registryUrl = "http://dns-server-app:8081/getRegisteredApplications";

    public IspServerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/perfil")
    public ResponseEntity<?> handleProfileRequest(@RequestBody ProfileRequestDTO requestBody)
            throws JsonMappingException, JsonProcessingException {
        var responseJson = restTemplate.getForObject(registryUrl, String.class);

        if (responseJson == null || responseJson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registry response is empty");
        }

        var instanceUrl = findInstanceUrl(responseJson, "PERFIL-APP");

        if (instanceUrl == null || instanceUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("PERFIL-APP instance URL not found");
        }

        instanceUrl += "perfil";
        System.out.println("[REDIRECTING] to target URL: " + instanceUrl);

        ProfileResponseDTO responseEntity = restTemplate.postForObject(instanceUrl, requestBody,
                ProfileResponseDTO.class);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/validacao")
    public ResponseEntity<?> handleValidationRequest(@RequestBody ValidacaoRequestDTO requestBody)
            throws JsonMappingException, JsonProcessingException {
        var responseJson = restTemplate.getForObject(registryUrl, String.class);

        if (responseJson == null || responseJson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registry response is empty");
        }

        var instanceUrl = findInstanceUrl(responseJson, "VALIDACAO-APP");

        if (instanceUrl == null || instanceUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("VALIDACAO-APP instance URL not found");
        }

        instanceUrl += "validacao";
        System.out.println("[REDIRECTING] to target URL: " + instanceUrl);

        ValidacaoResponseDTO responseEntity = restTemplate.postForObject(instanceUrl, requestBody,
                ValidacaoResponseDTO.class);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping(value = "/perfil/salvarArquivo/{fileName}")
    public ResponseEntity<String> uploadFile(
            @RequestPart("file") MultipartFile file,
            @PathVariable("fileName") String fileName) throws Exception {

        if(fileName == null || fileName.isBlank()) {
            throw new Exception("É necessário informar na rota um nome para o arquivo: '/perfil/salvarArquivo/{fileName}'.");
        }

        if (file == null || file.isEmpty()) {
            throw new Exception("É necessário enviar um arquivo não vazio do tipo .txt");
        }

        if (!"text/plain".equals(file.getContentType())) {
            throw new Exception("Apenas arquivos do tipo .txt são aceitos (fileType: "+file.getContentType()+")");
        }

        byte[] bytes = file.getBytes();
        Path path = Paths.get(file.getOriginalFilename());
        Files.write(path, bytes);
        return new ResponseEntity<>("File received with success, file: "+path.getFileName()+" and fileName: "+fileName, HttpStatus.OK);
    }

    private String findInstanceUrl(String responseJson, String appName)
            throws JsonMappingException, JsonProcessingException {

        var mapper = new ObjectMapper();
        var rootNode = mapper.readTree(responseJson);
        var applicationsNode = rootNode.path("applications").path("application");

        for (JsonNode applicationNode : applicationsNode) {
            var name = applicationNode.path("name").asText();

            if (name.equals(appName)) {
                var instanceNode = applicationNode.path("instance").get(0);
                var instanceUrl = instanceNode.path("homePageUrl").asText();

                if (!instanceUrl.startsWith("http://") && !instanceUrl.startsWith("https://")) {
                    instanceUrl = "http://" + instanceUrl;
                }

                return instanceUrl;
            }
        }

        throw new RuntimeException("[ERROR] Application not found: " + appName);
    }
}
