package com.example.equiposmedicos.usecase;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteEquipoMedico {

    Mono<Void> get(String id);
}
