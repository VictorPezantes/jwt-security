package com.pe.ttk.admision.dto;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

public class OfertaDto {


    private String estado;
    private String titulo;
    private String descripcion;

    private String requisito;

    private String creador;

    private String fechaCreacion;

    private String fechaPublicacion;

    private String CargoPostular;

    public int cantidadPostulantes;

    public OfertaDto() {
    }

    public OfertaDto(String estado, String titulo, String descripcion, String requisito, String creador, String fechaCreacion, String fechaPublicacion, String cargoPostular, int cantidadPostulantes) {
        this.estado = estado;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.requisito = requisito;
        this.creador = creador;
        this.fechaCreacion = fechaCreacion;
        this.fechaPublicacion = fechaPublicacion;
        CargoPostular = cargoPostular;
        this.cantidadPostulantes = cantidadPostulantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getCargoPostular() {
        return CargoPostular;
    }

    public void setCargoPostular(String cargoPostular) {
        CargoPostular = cargoPostular;
    }

    public int getCantidadPostulantes() {
        return cantidadPostulantes;
    }

    public void setCantidadPostulantes(int cantidadPostulantes) {
        this.cantidadPostulantes = cantidadPostulantes;
    }
}
