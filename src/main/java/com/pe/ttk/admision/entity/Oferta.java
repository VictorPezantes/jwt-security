package com.pe.ttk.admision.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estado;
    private String titulo;
    private String descripcion;
    private String requisito;
    private String creador;
    private Date fechaCreacion;
    private Date fechaPublicacion;
    private String CargoPostular;
    @Column(name = "cantidad_postulantes")
    public int cantidadPostulantes;


}
