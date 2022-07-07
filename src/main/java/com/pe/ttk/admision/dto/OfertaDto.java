package com.pe.ttk.admision.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfertaDto {

    private int id;
    private String estado;
    private String titulo;
    private String descripcion;
    private String requisito;
    private String creador;
    private String fechaCreacion;
    private String fechaPublicacion;
    private String CargoPostular;
    private int cantidadPostulantes;
    private String fechaActualización;
    private String fechaDesactivado;
}
