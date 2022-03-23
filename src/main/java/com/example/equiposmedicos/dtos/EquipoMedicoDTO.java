package com.example.equiposmedicos.dtos;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

public class EquipoMedicoDTO {

    @Id
    private String id;
    private String nombre;
    private String ubicacion;
    private String marca;
    private String serie;
    private String descripcion;
    private LocalDate fechaMantenimiento;
    private LocalDate fechaAdquisicion;

    public EquipoMedicoDTO() {
    }

    public EquipoMedicoDTO(String id, String nombre, String ubicacion, String marca, String serie, String descripcion, LocalDate fechaMantenimiento, LocalDate fechaAdquisicion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.marca = marca;
        this.serie = serie;
        this.descripcion = descripcion;
        this.fechaMantenimiento = fechaMantenimiento;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getId() {


        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(LocalDate fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipoMedicoDTO that = (EquipoMedicoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(ubicacion, that.ubicacion) && Objects.equals(marca, that.marca) && Objects.equals(serie, that.serie) && Objects.equals(descripcion, that.descripcion) && Objects.equals(fechaMantenimiento, that.fechaMantenimiento) && Objects.equals(fechaAdquisicion, that.fechaAdquisicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, ubicacion, marca, serie, descripcion, fechaMantenimiento, fechaAdquisicion);
    }
}
