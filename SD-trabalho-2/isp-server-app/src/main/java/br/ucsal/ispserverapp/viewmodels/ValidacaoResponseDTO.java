package br.ucsal.ispserverapp.viewmodels;

public class ValidacaoResponseDTO {

    private String message;

    public ValidacaoResponseDTO(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
