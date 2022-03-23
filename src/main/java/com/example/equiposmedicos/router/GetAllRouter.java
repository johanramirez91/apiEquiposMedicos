package com.example.equiposmedicos.router;

import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.usecase.GetAllEM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class GetAllRouter {

    @Bean
    public RouterFunction<ServerResponse> getAll(GetAllEM getAllEM){
        return route(GET("/stock/listaEM").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllEM.get(), EquipoMedicoDTO.class)));
    }
}
