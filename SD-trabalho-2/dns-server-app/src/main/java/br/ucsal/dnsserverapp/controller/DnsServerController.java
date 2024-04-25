package br.ucsal.dnsserverapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String getRegisteredApplications() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(applicationDiscoveryURI))
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .build();
            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }


    }
}
