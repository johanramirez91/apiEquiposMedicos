package com.example.equiposmedicos.usecase;

import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GetById {

    Mono<EquipoMedicoDTO> get(String id);
}
