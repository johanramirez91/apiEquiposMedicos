package com.example.equiposmedicos.usecase;

import com.example.equiposmedicos.repository.RepositorioEquipoMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class DeleteEMImplement implements DeleteEquipoMedico{

    private final RepositorioEquipoMedico repositorioEquipoMedico;

    @Autowired
    public DeleteEMImplement(RepositorioEquipoMedico repositorioEquipoMedico) {
        this.repositorioEquipoMedico = repositorioEquipoMedico;
    }

    @Override
    public Mono<Void> get(String id) {
        if (Objects.isNull(id)){
            return Mono.empty();
        }
        return repositorioEquipoMedico.deleteById(id);
    }
}
