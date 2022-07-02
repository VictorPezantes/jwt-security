package com.pe.ttk.admision.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


}
