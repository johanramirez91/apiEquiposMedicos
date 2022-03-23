package com.example.equiposmedicos.usecase;


import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.mapper.EquipoMedicoMapper;
import com.example.equiposmedicos.repository.RepositorioEquipoMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class GetAllEM implements Supplier<Flux<EquipoMedicoDTO>> {

    private final RepositorioEquipoMedico repositorioEquipoMedico;
    private final EquipoMedicoMapper mapper;

    @Autowired
    public GetAllEM(RepositorioEquipoMedico repositorioEquipoMedico, EquipoMedicoMapper mapper) {
        this.repositorioEquipoMedico = repositorioEquipoMedico;
        this.mapper = mapper;
    }

    @Override
    public Flux<EquipoMedicoDTO> get() {
        return repositorioEquipoMedico.findAll().map(mapper.mapperToDTO());
    }
}
