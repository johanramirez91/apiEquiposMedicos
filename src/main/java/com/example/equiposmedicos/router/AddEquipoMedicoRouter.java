package com.example.equiposmedicos.router;

import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.usecase.AddEquipoMedicoImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class AddEquipoMedicoRouter {

    @Bean
    public RouterFunction<ServerResponse> addEquipoMedico(AddEquipoMedicoImplement addEquipoMedicoImplement){
        return route(POST("/stock/addEM").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(EquipoMedicoDTO.class)
                        .flatMap(equipoMedicoDTO -> addEquipoMedicoImplement
                                .apply(equipoMedicoDTO)
                                .flatMap(result -> ServerResponse.status(HttpStatus.CREATED)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))));
    }
}
