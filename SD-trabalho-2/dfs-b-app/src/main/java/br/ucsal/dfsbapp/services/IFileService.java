package br.ucsal.dfsbapp.services;

import br.ucsal.dfsbapp.viewmodels.*;

public interface IFileService {
    SaveFileResponseDTO saveFile(SaveFileRequestDTO dto);
    GetFileResponseDTO getFile(GetFileRequestDTO dto);
}
