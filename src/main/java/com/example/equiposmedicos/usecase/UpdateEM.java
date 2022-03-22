package com.example.equiposmedicos.usecase;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdateEM {

    Mono<String> apply(String id);
}
