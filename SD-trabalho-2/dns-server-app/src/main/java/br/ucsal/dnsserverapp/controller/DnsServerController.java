package br.ucsal.dnsserverapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class DnsServerController {

    @Value("${spring.application.service-discovery-app}")
    private String applicationDiscoveryURI;


    @GetMapping("/getRegisteredApplications")
    public String getRegisteredApplications(@RequestParam("appName") String appName) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(applicationDiscoveryURI))
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .build();
            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            JsonNode rootNode = new ObjectMapper().readTree(responseBody);
            JsonNode applicationsNode = rootNode.get("applications");
            for (JsonNode appNode : applicationsNode) {
                String appNameFromResponse = appNode.get("name").asText();
                if (appNameFromResponse.equals(appName)) {
                    JsonNode instancesNode = appNode.get("instance");
                    for (JsonNode instanceNode : instancesNode) {
                        String instanceIp = instanceNode.get("ipAddr").asText();
                        return instanceIp;
                    }
                }
            }
            return "Application not found";
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
