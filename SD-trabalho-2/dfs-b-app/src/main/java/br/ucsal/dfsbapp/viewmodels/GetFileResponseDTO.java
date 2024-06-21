package br.ucsal.dfsbapp.viewmodels;

import java.io.File;

public class GetFileResponseDTO {

    private String originApp;
    private String fileName;
    private File file;

    public GetFileResponseDTO() {
        super();
    }

    public GetFileResponseDTO(String fileName, String originApp){
        this.fileName = fileName;
        this.originApp = originApp;
    }
    
    public String getOriginApp() {
        return originApp;
    }

    public void setOriginApp(String originApp) {
        this.originApp = originApp;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}