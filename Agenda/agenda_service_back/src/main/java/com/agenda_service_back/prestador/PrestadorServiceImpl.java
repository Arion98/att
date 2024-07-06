package com.agenda_service_back.prestador;

import com.agenda_service_back.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestadorServiceImpl implements PrestadorService {

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private PrestadorMapper prestadorMapper;

    @Override
    public PrestadorDTO createPrestador(PrestadorDTO prestadorDTO) {
        Prestador prestador = prestadorMapper.toEntity(prestadorDTO);
        Prestador savedPrestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(savedPrestador);
    }

    @Override
    public List<PrestadorDTO> getAllPrestadores() {
        List<Prestador> prestadores = prestadorRepository.findAll();
        return prestadores.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PrestadorDTO> getPrestadorById(Long prestadorId) {
        return prestadorRepository.findById(prestadorId).map(prestadorMapper::toDTO);
    }

    @Override
    public PrestadorDTO updatePrestador(Long prestadorId, PrestadorDTO prestadorDTO) {
        Optional<Prestador> existingPrestadorOpt = prestadorRepository.findById(prestadorId);
        if (existingPrestadorOpt.isPresent()) {
            Prestador existingPrestador = existingPrestadorOpt.get();
            prestadorMapper.updateEntity(prestadorDTO, existingPrestador);
            Prestador updatedPrestador = prestadorRepository.save(existingPrestador);
            return prestadorMapper.toDTO(updatedPrestador);
        } else {
            throw new ResourceNotFoundException("Prestador not found with id " + prestadorId);
        }
    }

    @Override
    public void deletePrestador(Long prestadorId) {
        prestadorRepository.deleteById(prestadorId);
    }
}
