package com.pe.ttk.admision.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Postulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "direccion_principal")
    private String direccionPrincipal;
    private String distrito;
    private String provincia;
    private String departamento;
    @Column(name = "celular_principal")
    private String celularPrincipal;
    @Column(name = "celular_familiar")
    private String celularFamiliar;
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Column(name = "email_principal")
    private String emailPrincipal;
    @Column(name = "email_secundario")
    private String emailSecundario;
    private String profesion;
    @Column(name = "lugar_estudios")
    private String lugarEstudios;
    @Column(name = "ultimo_curso_realizado")
    private String ultimoCursoRealizado;
    @Column(name = "empresa_curso")
    private String empresaCurso;
    @Column(name = "trabajo_reciente")
    private String trabajoReciente;
    @Column(name = "fecha_ingreso_trabajo_reciente")
    private Date fechaIngresoTrabajoReciente;
    @Column(name = "fecha_salida_trabajo_reciente")
    private Date fechaSalidaTrabajoReciente;
    @Column(name = "empresa_trabajo_reciente")
    private String EmpresaTrabajoReciente;
    @Column(name = "motivo_salida_trabajo_reciente")
    private String motivoSalidaTrabajoReciente;
    @Column(name = "curriculum_vitae")
    private Byte[] curriculumVitae;
    @Column(name = "dni_frontal")
    private Byte[] dniFrontal;
    @Column(name = "dni_posterior")
    private Byte[] dniPosterior;
    private Byte[] fotografia;
    @Column(name = "respuesta_disponibilidad_viajar")
    private String respuestaDisponibilidadViajar;
    @Column(name = "respuesta_experiencia_mantencion")
    private String respuestaExperienciaMantencion;
    @Column(name = "estado_postulacion")
    private String estadoPostulacion;
    @Column(name = "sub_estado_postulacion")
    private String subEstadoPostulacion;
    @Column(name = "fecha_postulacion")
    private Date fechaPostulacion;






}
