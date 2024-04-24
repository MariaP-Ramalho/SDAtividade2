package br.ucsal.dnsserverapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DnsServerController {


    @GetMapping("/health")
    public String healthy() {
        return "DNS server rodando ";
    }
}
