package br.ucsal.ispserverapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IspServerController {

    @GetMapping("/health")
    public String healthy() {
        return "ISP server rodando";
    }

}
