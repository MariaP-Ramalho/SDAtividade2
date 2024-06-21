package br.ucsal.dfsmasterapp.viewmodels;

import java.io.File;

public class SaveFileRequestDTO {

    private String fileName;
    private File file;

    public SaveFileRequestDTO() {
        super();
    }

    public SaveFileRequestDTO(File file, String fileName) {
        this.file = file;
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