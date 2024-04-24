package br.ucsal.validacaoapp.controller;

import com.netflix.discovery.EurekaClient;

import br.ucsal.validacaoapp.services.IValidationService;
import br.ucsal.validacaoapp.viewmodels.ValidacaoRequestDTO;
import br.ucsal.validacaoapp.viewmodels.ValidacaoResponseDTO;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ValidacaoController {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    private final IValidationService service;

    public ValidacaoController(IValidationService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String healthy() {
        return "Validação app rodando.";
    }

    @PostMapping("/validacao")
    public ResponseEntity<ValidacaoResponseDTO> validateUser(@RequestBody ValidacaoRequestDTO dto) {
        var message = service.validateUser(dto.getEmail());
        var responseDTO = new ValidacaoResponseDTO(message);

        if(message.contains("não foi encontrado"))
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(responseDTO);

        return ResponseEntity.ok(responseDTO);
    }
}
