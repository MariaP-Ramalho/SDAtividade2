package br.ucsal.dnsserverapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class DNSServerHealthCheckController {

    private static final Logger logger = Logger.getLogger(DNSServerHealthCheckController.class.getName());

    @Value("${spring.service-discovery-app}")
    private String applicationDiscoveryURI;

    @GetMapping("/health")
    public ResponseEntity<String> healthy() {
        String message = "Sou o DNS Server e estou online: " + LocalDateTime.now();
        return ResponseEntity.ok(message);
    }

    @GetMapping("/getRegisteredApplications")
    public ResponseEntity<String> getRegisteredApplications() {
        try {
            URI uri = new URI(applicationDiscoveryURI);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
            return ResponseEntity.ok(response.body());
        } catch (URISyntaxException | InterruptedException | IllegalArgumentException | IOException e) {
            logger.log(Level.SEVERE, "Error processing request", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }
}