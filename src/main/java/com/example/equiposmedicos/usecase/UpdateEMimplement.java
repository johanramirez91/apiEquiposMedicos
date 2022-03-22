package com.example.equiposmedicos.usecase;

import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.mapper.EquipoMedicoMapper;
import com.example.equiposmedicos.repository.RepositorioEquipoMedico;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UpdateEMimplement implements AddEquipoMedico {

    private final RepositorioEquipoMedico repositorioEquipoMedico;
    private final EquipoMedicoMapper mapper;

    public UpdateEMimplement(RepositorioEquipoMedico repositorioEquipoMedico, EquipoMedicoMapper mapper) {
        this.repositorioEquipoMedico = repositorioEquipoMedico;
        this.mapper = mapper;
    }

    @Override
    public Mono<EquipoMedicoDTO> apply(EquipoMedicoDTO equipoMedicoDTO) {
        return repositorioEquipoMedico.save(mapper.mapperToEquipoMedico().apply(equipoMedicoDTO))
                .map(equipoMedico -> mapper.mapperToDTO().apply(equipoMedico));

    }
}
