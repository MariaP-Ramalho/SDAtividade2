package br.ucsal.perfilapp.services;

import br.ucsal.perfilapp.viewmodels.ProfileResponseDTO;

public interface IProfileService {
    
    ProfileResponseDTO getUserProfile(String email);
    void addUserProfile(String email, String profile);
}