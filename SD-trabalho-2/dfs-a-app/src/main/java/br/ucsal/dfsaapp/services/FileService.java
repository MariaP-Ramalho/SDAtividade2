package br.ucsal.dfsaapp.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import br.ucsal.dfsaapp.viewmodels.*;

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
                System.out.println("[DFS-A-APP] File " + outputFile + " already exists.");
                return new SaveFileResponseDTO("[ERRO] arquivo com o nome `"+outputFile+"`já existe", false);
            } else {
                Files.copy(inputFile.toPath(), outputFile);
                System.out.println("[DFS-A-APP] File saved to: " + outputFile);
                return new SaveFileResponseDTO(outputFile.getFileName().toString(), true);
            }
        } catch (IOException e) {
            System.err.println("[DFS-A-APP] Failed to save file: " + e.getMessage());
            e.printStackTrace();
            return new SaveFileResponseDTO("[ERRO] erro interno", false);
        }
    }

    @Override
    public GetFileResponseDTO getFile(GetFileRequestDTO dto) {
        String fileName = dto.getFileName();
        Path filePath = Paths.get(outputDirectory, fileName);
        File file = filePath.toFile();

        if (file.exists() && file.isFile()) {
            GetFileResponseDTO response = new GetFileResponseDTO(fileName, "App A");
            response.setFile(file);
            System.out.println("[DFS-A-APP] File " + filePath + " retrieved successfully.");
            return response;
        } else {
            System.err.println("[DFS-A-APP] File " + filePath + " does not exist or is not a file.");
            return new GetFileResponseDTO(null, "App A");
        }
    }
}
