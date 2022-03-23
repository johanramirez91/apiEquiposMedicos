package com.example.equiposmedicos.mapper;

import com.example.equiposmedicos.collections.EquipoMedico;
import com.example.equiposmedicos.dtos.EquipoMedicoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EquipoMedicoMapper {

    public Function<EquipoMedicoDTO, EquipoMedico> mapperToEquipoMedico(){
        return equipoMedico -> {
            var equipo = new EquipoMedico();
            equipo.setId(equipoMedico.getId());
            equipo.setNombre(equipoMedico.getNombre());
            equipo.setUbicacion(equipoMedico.getUbicacion());
            equipo.setMarca(equipoMedico.getMarca());
            equipo.setSerie(equipoMedico.getSerie());
            equipo.setDescripcion(equipoMedico.getDescripcion());
            equipo.setFechaMantenimiento(equipoMedico.getFechaMantenimiento());
            equipo.setFechaAdquisicion(equipoMedico.getFechaAdquisicion());
            return equipo;
        };
    }

    public Function<EquipoMedico, EquipoMedicoDTO> mapperToDTO(){
        return entity -> new EquipoMedicoDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getUbicacion(),
                entity.getMarca(),
                entity.getSerie(),
                entity.getDescripcion(),
                entity.getFechaMantenimiento(),
                entity.getFechaAdquisicion()
        );
    }
}
