package br.ucsal.dfsaapp.viewmodels;

public class SaveFileResponseDTO {

    private String fileName;
    private boolean success;

    public SaveFileResponseDTO() {
        super();
    }

    public SaveFileResponseDTO(String fileName, boolean success) {
        this.fileName = fileName;
        this.success = success;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}