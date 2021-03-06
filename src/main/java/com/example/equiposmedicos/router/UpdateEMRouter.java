package com.example.equiposmedicos.router;

import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.usecase.UpdateEMimplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateEMRouter {

    @Bean
    public RouterFunction<ServerResponse> updateEM(UpdateEMimplement updateEMimplement) {
        return route(PUT("/stock/updateEM").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(EquipoMedicoDTO.class)
                        .flatMap(equipoMedicoDTO -> updateEMimplement.apply(equipoMedicoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))));
    }
}
