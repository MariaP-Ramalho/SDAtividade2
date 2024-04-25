package br.ucsal.perfilapp.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ucsal.perfilapp.viewmodels.ProfileResponseDTO;

@Service
public class ProfileService implements IProfileService {
    
    private final Map<String, String> userProfileMap = new HashMap<>();

    public ProfileService() {
        initializeUserProfileMap();
    }

    private void initializeUserProfileMap() {
        userProfileMap.put("everton@pro.ucsal.br", "Professor");
        userProfileMap.put("jose@ucsal.edu.br", "Funcionario");
        userProfileMap.put("carolina@ucsal.edu.br", "Aluno");
        userProfileMap.put("maria@ucsal.edu.br", "Aluno");
        userProfileMap.put("joao@ucsal.edu.br", "Aluno");
    }

    public void addUserProfile(String email, String profile) {
        userProfileMap.put(email, profile);
    }

    public ProfileResponseDTO getUserProfile(String email) {
        String profile = userProfileMap.get(email);
        if (profile != null) {
            return new ProfileResponseDTO(email, profile);
        } else {
            return null;
        }
    }
}
