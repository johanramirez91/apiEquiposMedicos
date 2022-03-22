package com.example.equiposmedicos.usecase;

import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.mapper.EquipoMedicoMapper;
import com.example.equiposmedicos.repository.RepositorioEquipoMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class GetByIdImplement implements GetById{

    private final RepositorioEquipoMedico repositorioEquipoMedico;
    private final EquipoMedicoMapper mapper;

    @Autowired
    public GetByIdImplement(RepositorioEquipoMedico repositorioEquipoMedico, EquipoMedicoMapper mapper) {
        this.repositorioEquipoMedico = repositorioEquipoMedico;
        this.mapper = mapper;
    }

    @Override
    public Mono<EquipoMedicoDTO> get(String id) {
        return repositorioEquipoMedico.findById(id).map(mapper.mapperToDTO());
    }
}
