package br.ucsal.validacaoapp.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.validacaoapp.services.IValidationService;
import br.ucsal.validacaoapp.viewmodels.ValidacaoRequestDTO;
import br.ucsal.validacaoapp.viewmodels.ValidacaoResponseDTO;
import br.ucsal.validacaoapp.viewmodels.NotFoundResponseDTO;

@RestController
public class ValidacaoController {

    private final IValidationService service;

    public ValidacaoController(IValidationService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String healthy() {
        return "Validação app rodando.";
    }

    @PostMapping("/validacao")
    public ResponseEntity<?> validateUser(@RequestBody ValidacaoRequestDTO dto) {
        var message = service.validateUser(dto.getEmail());
        var responseDTO = new ValidacaoResponseDTO(message);

        if (message.contains("não foi encontrado")) {
            var errorMessage = new NotFoundResponseDTO("Usuário não encontrado para o email: " + dto.getEmail());
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(errorMessage);
        }

        return ResponseEntity.ok(responseDTO);
    }
}
