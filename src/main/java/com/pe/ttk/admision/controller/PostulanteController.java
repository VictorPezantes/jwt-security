package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.dto.PostulanteDto;
import com.pe.ttk.admision.entity.Oferta;
import com.pe.ttk.admision.entity.Postulante;
import com.pe.ttk.admision.service.OfertaService;
import com.pe.ttk.admision.service.PostulanteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postulante")
@CrossOrigin(origins = "http://localhost:4200")
public class PostulanteController {

    @Autowired
    PostulanteService postulanteService;

    @ApiOperation("Lista todos los postulantes")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista")
    public ResponseEntity<List<Postulante>> list(){
        List<Postulante> list = postulanteService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @ApiOperation("Lista los estudiantes por su estado de postulacion")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista/estadopostulacion/{estadopostulacion}")
    public ResponseEntity<Postulante> obtenerOfertaPorEstado(@PathVariable("estadopostulacion") String estadoPostulacion){

        List<Postulante> postulante = postulanteService.findByEstadoPostulacion(estadoPostulacion);
        return new ResponseEntity(postulante, HttpStatus.OK);
    }

    @ApiOperation("Muestra un Postulante por su primer nombre")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista/primernombre/{primernombre}")
    public ResponseEntity<Oferta> obtenerOfertaPorTítulo(@PathVariable("primernombre") String primerNombre){
        Optional<Postulante> postulante = postulanteService.findByPrimerNombre(primerNombre);
        return new ResponseEntity(postulante, HttpStatus.OK);
    }

    @ApiOperation("Registrar un nuevo postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarPostulante(@RequestBody PostulanteDto postulanteDto){

       Date fechaPostulacion= Date.valueOf(postulanteDto.getFechaPostulacion());
       Date fechaNacimiento = Date.valueOf(postulanteDto.getFechaNacimiento());
       Date fechaIngresoTrabajoReciente;
       Date fechaSalidaTrabajoreciente;

       Postulante postulante = new Postulante();

       if(postulanteDto.getFechaIngresoTrabajoReciente().isEmpty() || postulanteDto.getFechaSalidaTrabajoreciente().isEmpty()) {
           fechaIngresoTrabajoReciente = null;
           fechaSalidaTrabajoreciente = null;
       }else{
           fechaIngresoTrabajoReciente =Date.valueOf(postulanteDto.getFechaIngresoTrabajoReciente());
           fechaSalidaTrabajoreciente = Date.valueOf(postulanteDto.getFechaSalidaTrabajoreciente());
       }
        postulante.setFechaIngresoTrabajoReciente(fechaIngresoTrabajoReciente);
        postulante.setFechaSalidaTrabajoReciente(fechaSalidaTrabajoreciente);
        postulante.setApellidoMaterno(postulanteDto.getApellidoMaterno());
        postulante.setApellidoPaterno(postulanteDto.getApellidoPaterno());
        postulante.setCelularFamiliar(postulanteDto.getCelularFamiliar());
        postulante.setCelularPrincipal(postulanteDto.getCelularPrincipal());
        postulante.setDepartamento(postulanteDto.getDepartamento());
        postulante.setCurriculumVitae(postulanteDto.getCurriculumVitae());
        postulante.setDistrito(postulanteDto.getDistrito());
        postulante.setDniFrontal(postulanteDto.getDniFrontal());
        postulante.setDniPosterior(postulanteDto.getDniPosterior());
        postulante.setEmailPrincipal(postulanteDto.getEmailPrincipal());
        postulante.setEmailSecundario(postulanteDto.getEmailSecundario());
        postulante.setEmpresaCurso(postulanteDto.getEmpresaCurso());
        postulante.setDireccionPrincipal(postulanteDto.getDireccionPrincipal());
        postulante.setEmpresaTrabajoReciente(postulanteDto.getEmpresaTrabajoReciente());
        postulante.setEstadoCivil(postulanteDto.getEstadoCivil());
        postulante.setEstadoPostulacion(postulanteDto.getEstadoPostulacion());
        postulante.setFotografia(postulanteDto.getFotografia());
        postulante.setTelefonoFijo(postulanteDto.getTelefonoFijo());
        postulante.setRespuestaDisponibilidadViajar(postulanteDto.getRespuestaDisponibilidadViajar());
        postulante.setRespuestaExperienciaMantencion(postulanteDto.getRespuestaExperienciaMantencion());
        postulante.setFechaNacimiento(fechaNacimiento);
        postulante.setFechaPostulacion(fechaPostulacion);
        postulante.setPrimerNombre(postulanteDto.getPrimerNombre());
        postulante.setSegundoNombre(postulanteDto.getSegundoNombre());
        postulante.setSubEstadoPostulacion(postulanteDto.getSubEstadoPostulacion());
        postulante.setUltimoCursoRealizado(postulante.getUltimoCursoRealizado());
        postulante.setTrabajoReciente(postulanteDto.getTrabajoReciente());
        postulante.setLugarEstudios(postulanteDto.getLugarEstudios());
        postulante.setProfesion(postulanteDto.getProfesion());
        postulanteService.save(postulante);
        return new ResponseEntity(new Mensaje("Postulante registrado correctamente"), HttpStatus.CREATED);
    }

    @ApiOperation("Actualizar distintos campos de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPostulante(@PathVariable("id")int id, @RequestBody PostulanteDto postulanteDto){

        Date fechaPostulacion= Date.valueOf(postulanteDto.getFechaPostulacion());
        Date fechaNacimiento = Date.valueOf(postulanteDto.getFechaNacimiento());
        Date fechaIngresoTrabajoReciente;
        Date fechaSalidaTrabajoreciente;


        if(postulanteDto.getFechaIngresoTrabajoReciente()== null || postulanteDto.getFechaSalidaTrabajoreciente()==null) {
            fechaIngresoTrabajoReciente = null;
            fechaSalidaTrabajoreciente = null;
        }else{
            fechaIngresoTrabajoReciente =Date.valueOf(postulanteDto.getFechaIngresoTrabajoReciente());
            fechaSalidaTrabajoreciente = Date.valueOf(postulanteDto.getFechaSalidaTrabajoreciente());
        }

        Postulante postulante = postulanteService.getOne(id).get();
        postulante.setFechaIngresoTrabajoReciente(fechaIngresoTrabajoReciente);
        postulante.setFechaSalidaTrabajoReciente(fechaSalidaTrabajoreciente);
        postulante.setApellidoMaterno(postulanteDto.getApellidoMaterno());
        postulante.setApellidoPaterno(postulanteDto.getApellidoPaterno());
        postulante.setCelularFamiliar(postulanteDto.getCelularFamiliar());
        postulante.setCelularPrincipal(postulanteDto.getCelularPrincipal());
        postulante.setDepartamento(postulanteDto.getDepartamento());
        postulante.setCurriculumVitae(postulanteDto.getCurriculumVitae());
        postulante.setDistrito(postulanteDto.getDistrito());
        postulante.setDniFrontal(postulanteDto.getDniFrontal());
        postulante.setDniPosterior(postulanteDto.getDniPosterior());
        postulante.setEmailPrincipal(postulanteDto.getEmailPrincipal());
        postulante.setEmailSecundario(postulanteDto.getEmailSecundario());
        postulante.setEmpresaCurso(postulanteDto.getEmpresaCurso());
        postulante.setDireccionPrincipal(postulanteDto.getDireccionPrincipal());
        postulante.setEmpresaTrabajoReciente(postulanteDto.getEmpresaTrabajoReciente());
        postulante.setEstadoCivil(postulanteDto.getEstadoCivil());
        postulante.setEstadoPostulacion(postulanteDto.getEstadoPostulacion());
        postulante.setFotografia(postulanteDto.getFotografia());
        postulante.setTelefonoFijo(postulanteDto.getTelefonoFijo());
        postulante.setRespuestaDisponibilidadViajar(postulanteDto.getRespuestaDisponibilidadViajar());
        postulante.setRespuestaExperienciaMantencion(postulanteDto.getRespuestaExperienciaMantencion());
        postulante.setFechaNacimiento(fechaNacimiento);
        postulante.setFechaPostulacion(fechaPostulacion);
        postulante.setPrimerNombre(postulanteDto.getPrimerNombre());
        postulante.setSegundoNombre(postulanteDto.getSegundoNombre());
        postulante.setSubEstadoPostulacion(postulanteDto.getSubEstadoPostulacion());
        postulante.setUltimoCursoRealizado(postulante.getUltimoCursoRealizado());
        postulante.setTrabajoReciente(postulanteDto.getTrabajoReciente());
        postulante.setLugarEstudios(postulanteDto.getLugarEstudios());
        postulante.setProfesion(postulanteDto.getProfesion());
        postulanteService.save(postulante);
        return new ResponseEntity(new Mensaje("Datos del estudiante actualizados correctamente"), HttpStatus.ACCEPTED);
    }

}
