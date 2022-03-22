package com.example.equiposmedicos.usecase;

import com.example.equiposmedicos.collections.EquipoMedico;
import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.mapper.EquipoMedicoMapper;
import com.example.equiposmedicos.repository.RepositorioEquipoMedico;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UpdateEMimplement implements UpdateEM {

    private final RepositorioEquipoMedico repositorioEquipoMedico;

    public UpdateEMimplement(RepositorioEquipoMedico repositorioEquipoMedico) {
        this.repositorioEquipoMedico = repositorioEquipoMedico;
    }

    @Override
    public Mono<String> apply(String id) {
        Mono<EquipoMedico> equipoMedicoMono = repositorioEquipoMedico.findById(id);
        return equipoMedicoMono.flatMap(equipoMedico -> {
            if (!equipoMedico.getId().isEmpty()){
                return repositorioEquipoMedico.save(equipoMedico).thenReturn("Equipo médico actualizado exitosamente");
            }
            return Mono.just("El Equipo NO fue actualizado");
        });

    }
}
