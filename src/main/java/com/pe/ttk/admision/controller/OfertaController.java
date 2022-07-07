package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.entity.Oferta;
import com.pe.ttk.admision.service.impl.OfertaServiceImpl;
import com.pe.ttk.admision.util.PaginationUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oferta")
@CrossOrigin(origins = "http://localhost:4200")
public class OfertaController {

    @Autowired
    OfertaServiceImpl ofertaService;

    @ApiOperation("Lista todas las ofertas creadas y paginación")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/lista", produces = "application/json")
    public String  listarOfertas(@RequestParam(value = "numpagina") Integer page,
                                 @RequestParam(value = "size") Integer size,
                                 Model model){
        List<Oferta> listaOfertas = ofertaService.listarOfertas();
        return PaginationUtils.getPaginationedResults(listaOfertas, page, size, model);
    }
    @ApiOperation("Lista las ofertas filtradas por su estado y paginación")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/lista/estados",produces = "application/json")
    public String obtenerOfertaPorEstado(@RequestParam("estado") String estado,
                                         @RequestParam(value = "numpagina") Integer page,
                                         @RequestParam(value = "size") Integer size,
                                         Model model){

        List<Oferta> listaOfertas = ofertaService.findByEstado(estado);
        return PaginationUtils.getPaginationedResults(listaOfertas, page, size, model);
    }
    @ApiOperation("Lista las ofertas creadas por un usuario específico y paginación")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/lista/creador",produces = "application/json")
    public String obtenerOfertaPorCreador(@RequestParam("creador") String creador,
                                          @RequestParam(value = "numpagina") Integer page,
                                          @RequestParam(value = "size") Integer size,
                                          Model model){

        List<Oferta> listaOfertas = ofertaService.findByCreador(creador);
        return PaginationUtils.getPaginationedResults(listaOfertas, page, size, model);
    }
    @ApiOperation("Muestra una oferta buscada por su título")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/titulo",produces = "application/json")
    public ResponseEntity<Oferta> obtenerOfertaPorTítulo(@RequestParam("titulo") String titulo){
        Optional<Oferta> oferta = ofertaService.findByTitulo(titulo);
        return new ResponseEntity(oferta, HttpStatus.OK);
    }
    @ApiOperation("Lista  las ofertas por fecha de Publicación y paginación")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "lista/fechapublicacion",produces = "application/json")
    public String obetenerOfertaPorFechaPublicacion(@RequestParam("fechapublicacion") Date fechaPublicacion,
                                                    @RequestParam(value = "numpagina") Integer page,
                                                    @RequestParam(value = "size") Integer size,
                                                    Model model){
        List<Oferta> listaOfertas = ofertaService.findByFechaPublicacion(fechaPublicacion);
        return PaginationUtils.getPaginationedResults(listaOfertas, page, size, model);
    }
    @ApiOperation("Crear ofertas")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearOferta(@RequestBody OfertaDto ofertaDto){

        ofertaService.registrarOferta(ofertaDto);
        return new ResponseEntity(new Mensaje("Oferta creada"), HttpStatus.CREATED);
    }
    @ApiOperation("Actualizar distintos campos de una oferta")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarOferta(@PathVariable("id")int id, @RequestBody OfertaDto ofertaDto){

        ofertaService.actualizarOferta(id,ofertaDto);
        return new ResponseEntity(new Mensaje("oferta actualizada"), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Actualizar estado  de una oferta")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/estado/{id}")
    public ResponseEntity<?> actualizarEstadoOferta(@PathVariable("id")int id, @RequestBody OfertaDto ofertaDto){

        ofertaService.actualizarEstado(id,ofertaDto);
        return new ResponseEntity(new Mensaje("El estado de la oferta ha sido actualizado "), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Eliminar oferta por id")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eliminar")
    public ResponseEntity<?> eliminarOferta(@RequestParam("id")int id){

        ofertaService.delete(id);
        return new ResponseEntity(new Mensaje("Oferta eliminada"), HttpStatus.OK);
    }

}
