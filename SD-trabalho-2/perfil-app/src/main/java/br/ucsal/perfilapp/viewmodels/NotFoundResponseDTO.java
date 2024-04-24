package br.ucsal.perfilapp.viewmodels;

public class NotFoundResponseDTO {

    private String errorMessage;

    public NotFoundResponseDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
