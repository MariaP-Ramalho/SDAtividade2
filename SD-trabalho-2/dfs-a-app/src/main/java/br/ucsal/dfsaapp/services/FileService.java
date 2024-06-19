package br.ucsal.dfsaapp.services;

import java.io.File;

import org.springframework.stereotype.Service;

import br.ucsal.dfsaapp.viewmodels.*;

@Service
public class FileService implements IFileService {

    private File file;
    private String fileName;

    public FileService() {
        super();
    }

    @Override
    public SaveFileResponseDTO saveFile(SaveFileRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveFile'");
    }

    @Override
    public GetFileResponseDTO getFile(GetFileRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFile'");
    }
}