package br.ucsal.perfilapp.viewmodels;

public class ProfileResponseDTO {

    private String email;
    private String perfil;

    public ProfileResponseDTO(String email, String perfil) {
        this.email = email;
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}

