package com.example.equiposmedicos.router;
import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.usecase.GetByIdImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> getById(GetByIdImplement getByIdImplement){
        return route(GET("/stock/getById/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getByIdImplement.get(request.pathVariable("id")), EquipoMedicoDTO.class)));

    }
}
