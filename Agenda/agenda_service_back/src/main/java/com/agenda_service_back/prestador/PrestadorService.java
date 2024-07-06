package com.agenda_service_back.prestador;

import java.util.List;
import java.util.Optional;

public interface PrestadorService {
    PrestadorDTO createPrestador(PrestadorDTO prestadorDTO);

    List<PrestadorDTO> getAllPrestadores();

    Optional<PrestadorDTO> getPrestadorById(Long prestadorId);

    PrestadorDTO updatePrestador(Long prestadorId, PrestadorDTO prestadorDTO);

    void deletePrestador(Long prestadorId);
}
