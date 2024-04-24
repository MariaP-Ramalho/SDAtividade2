package br.ucsal.perfilapp.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.perfilapp.services.IProfileService;
import br.ucsal.perfilapp.viewmodels.NotFoundResponseDTO;
import br.ucsal.perfilapp.viewmodels.ProfileRequestDTO;
import br.ucsal.perfilapp.viewmodels.ProfileResponseDTO;

@RestController
public class PerfilController {

    private final IProfileService service;

    public PerfilController(IProfileService service) {
        this.service = service;
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
}
