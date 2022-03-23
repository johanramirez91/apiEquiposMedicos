package com.example.equiposmedicos.routers;

import com.example.equiposmedicos.collections.EquipoMedico;
import com.example.equiposmedicos.repository.RepositorioEquipoMedico;
import com.example.equiposmedicos.router.DeleteEquipoMedicoRouter;
import com.example.equiposmedicos.usecase.DeleteEMImplement;
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
@ContextConfiguration(classes = {DeleteEquipoMedicoRouter.class, DeleteEMImplement.class})
class DeleteEMTest {

    @MockBean
    private RepositorioEquipoMedico repositorioEquipoMedico;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void deleteEM(){

        var equipo1 = new EquipoMedico();

        equipo1.setId("e12345");
        equipo1.setNombre("Rayos X");
        equipo1.setUbicacion("Medicina Nuclear");
        equipo1.setMarca("Siemens");
        equipo1.setSerie("abc123");
        equipo1.setDescripcion("peso: 200 kg");
        equipo1.setFechaMantenimiento(LocalDate.of(2022,3, 25));
        equipo1.setFechaAdquisicion(LocalDate.of(2015,10,10));

        Mockito.when(repositorioEquipoMedico.deleteById(equipo1.getId())).thenReturn(Mono.empty());

        webTestClient.delete()
                .uri("/stock/eliminar/e12345")
                .exchange()
                .expectStatus().isAccepted()
                .expectBody().isEmpty();
    }
}
