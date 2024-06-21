package br.ucsal.dfsbapp.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import br.ucsal.dfsbapp.viewmodels.*;

@Service
public class FileService implements IFileService {

    private final String outputDirectory = "/app/ProfileVersions";

    public FileService() {
        super();
    }

    @Override
    public SaveFileResponseDTO saveFile(SaveFileRequestDTO dto) {
        File inputFile = dto.getFile();
        Path outputFile = Paths.get(outputDirectory, dto.getFileName());

        try {
            Files.createDirectories(outputFile.getParent());

            if (Files.exists(outputFile)) {
                System.out.println("[DFS-B-APP] File " + outputFile + " already exists.");
                return new SaveFileResponseDTO(null, false);
            } else {
                Files.copy(inputFile.toPath(), outputFile);
                System.out.println("[DFS-B-APP] File saved to: " + outputFile);
                return new SaveFileResponseDTO(outputFile.getFileName().toString(), true);
            }
        } catch (IOException e) {
            System.err.println("[DFS-B-APP] Failed to save file: " + e.getMessage());
            e.printStackTrace();
            return new SaveFileResponseDTO(null, false);
        }
    }


    @Override
    public GetFileResponseDTO getFile(GetFileRequestDTO dto) {
        return new GetFileResponseDTO(dto.getFileName(), "App B");
    }
}