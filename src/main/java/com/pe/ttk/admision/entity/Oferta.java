package com.pe.ttk.admision.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

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

    public Oferta() {
    }

    public Oferta(String estado, String titulo, String descripcion, String requisito, String creador, Date fechaCreacion, Date fechaPublicacion, String cargoPostular, int cantidadPostulantes) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
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
