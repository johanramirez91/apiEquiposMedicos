package com.example.equiposmedicos.router;

import com.example.equiposmedicos.usecase.DeleteEMImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class DeleteEquipoMedicoRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteEquipoMedico(DeleteEMImplement deleteEMImplement){
        return route(RequestPredicates.DELETE("/stock/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(deleteEMImplement.get(request.pathVariable("id")), Void.class))
                        .onErrorResume(error -> ServerResponse.notFound().build()));
    }
}
