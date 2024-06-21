package br.ucsal.ispserverapp.viewmodels;

import java.io.File;

public class GetFileRequestDTO {

    private String fileName;
    private File file;

    public GetFileRequestDTO() {
        super();
    }
    public GetFileRequestDTO(String fileName) {
        this.fileName = fileName;
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