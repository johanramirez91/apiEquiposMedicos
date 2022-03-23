package com.example.equiposmedicos.routers;

import com.example.equiposmedicos.collections.EquipoMedico;
import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import com.example.equiposmedicos.mapper.EquipoMedicoMapper;
import com.example.equiposmedicos.repository.RepositorioEquipoMedico;
import com.example.equiposmedicos.router.GetByIdRouter;
import com.example.equiposmedicos.usecase.GetByIdImplement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {GetByIdRouter.class, GetByIdImplement.class, EquipoMedicoMapper.class})
public class GetByIdTest {

    @MockBean
    private RepositorioEquipoMedico repositorioEquipoMedico;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getById(){

        var equipo1 = new EquipoMedico();

        equipo1.setId("e12345");
        equipo1.setNombre("Rayos X");
        equipo1.setUbicacion("Medicina Nuclear");
        equipo1.setMarca("Siemens");
        equipo1.setSerie("abc123");
        equipo1.setDescripcion("peso: 200 kg");
        equipo1.setFechaMantenimiento(LocalDate.of(2022,3, 25));
        equipo1.setFechaAdquisicion(LocalDate.of(2015,10,10));

        EquipoMedicoDTO equipoMedicoDTO = new EquipoMedicoDTO(
                equipo1.getId(),
                equipo1.getNombre(),
                equipo1.getUbicacion(),
                equipo1.getMarca(),
                equipo1.getSerie(),
                equipo1.getDescripcion(),
                equipo1.getFechaMantenimiento(),
                equipo1.getFechaAdquisicion()
        );

        Mono<EquipoMedico> equipoMedicoMono = Mono.just(equipo1);
        Mockito.when(repositorioEquipoMedico.findById(equipo1.getId())).thenReturn(equipoMedicoMono);

        webTestClient.get()
                .uri("/stock/getById/e12345")
                .exchange()
                .expectStatus().isOk()
                .expectBody(EquipoMedico.class)
                .value(response -> {
                    Assertions.assertThat(response.getId()).isEqualTo(equipo1.getId());
                });
    }
}
