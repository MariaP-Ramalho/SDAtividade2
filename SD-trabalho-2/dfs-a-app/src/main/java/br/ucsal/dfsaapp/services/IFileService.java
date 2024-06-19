package br.ucsal.dfsaapp.services;

import br.ucsal.dfsaapp.viewmodels.*;

public interface IFileService {
    SaveFileResponseDTO saveFile(SaveFileRequestDTO dto);
    GetFileResponseDTO getFile(GetFileRequestDTO dto);
}