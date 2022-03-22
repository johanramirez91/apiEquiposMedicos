package com.example.equiposmedicos.routers;

import com.example.equiposmedicos.collections.EquipoMedico;
import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.repository.RepositorioEquipoMedico;
import com.example.equiposmedicos.usecase.GetAllEM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { })
public class GetAlltest {

    @MockBean
    private RepositorioEquipoMedico repositorioEquipoMedico;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getAll(){

        var equipo1 = new EquipoMedico();

        equipo1.setId("e12345");
        equipo1.setNombre("Rayos X");
        equipo1.setUbicacion("Medicina Nuclear");
        equipo1.setMarca("Siemens");
        equipo1.setSerie("abc123");
        equipo1.setDescripcion("peso: 200 kg");
        equipo1.setFechaMantenimiento(LocalDate.of(2022,3, 25));
        equipo1.setFechaAdquisicion(LocalDate.of(2015,10,10));

        var equipo2 = new EquipoMedico();

        equipo2.setId("e987456");
        equipo2.setNombre("Maquina de anestesia");
        equipo2.setUbicacion("Salas de cirugia");
        equipo2.setMarca("Drager");
        equipo2.setSerie("an456");
        equipo2.setDescripcion("peso: 120 kg");
        equipo2.setFechaMantenimiento(LocalDate.of(2022,3, 22));
        equipo2.setFechaAdquisicion(LocalDate.of(2019,9,5));

        Mockito.when(repositorioEquipoMedico.findAll()).thenReturn(Flux.just(equipo1, equipo2));

        webTestClient.get()
                .uri("/stock/listaEM")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(EquipoMedicoDTO.class)
                .value(response -> {

                });
    }
}
