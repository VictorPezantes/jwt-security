package com.pe.ttk.admision.entity.oferta;

<<<<<<< HEAD
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
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.entity.master.Estado;
import lombok.*;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="oferta")
public class Oferta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String titulo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String requisito;
    @Column(nullable = false)
>>>>>>> 592b9d441f68429fc22c8886d2449f919edbe124
    private Date fechaCreacion;
    private Date fechaActualización;
    private Date fechaPublicacion;
    private Date fechaDesactivado;
<<<<<<< HEAD
    private String CargoPostular;
    @Column(name = "cantidad_postulantes")
    private int cantidadPostulantes;


=======
    @Column(nullable = false)
    private int cantidadPostulantes;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name ="fk_estado", referencedColumnName = "id")
    private Estado estadoOferta;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name ="fk_creador", referencedColumnName = "id")
    private Encargado creadorOferta;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name ="fk_cargo", referencedColumnName = "id")
    private Cargo cargoOferta;


>>>>>>> 592b9d441f68429fc22c8886d2449f919edbe124
}
