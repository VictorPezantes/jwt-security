package com.pe.ttk.admision.dto;

import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.entity.master.Estado;
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

    private Estado estadoOferta;
    private String titulo;
    private String descripcion;
    private String requisito;
    private Encargado creadorOferta;
    private String fechaCreacion;
    private String fechaPublicacion;
    private Cargo CargoOferta;
    private int cantidadPostulantes;
    private String fechaActualización;
    private String fechaDesactivado;
}
