package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.OfertaDto;
<<<<<<< HEAD
import com.pe.ttk.admision.entity.oferta.Oferta;
=======
import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.oferta.Oferta;
import com.pe.ttk.admision.service.impl.CargoServieImp;
>>>>>>> 592b9d441f68429fc22c8886d2449f919edbe124
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oferta")
@CrossOrigin(origins = "http://localhost:4200")
public class OfertaController {

    @Autowired
    OfertaServiceImpl ofertaService;


    @ApiOperation("Lista todas las ofertas creadas")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/lista", produces = "application/json")
    public String  listarOfertas(@RequestParam(value = "numpagina") Integer page,
                                            @RequestParam(value = "size") Integer size,
                                            Model model){
        List<Oferta> listaOfertas = ofertaService.listarOfertas();

        return PaginationUtils.getPaginationedResults(listaOfertas, page, size, model);
    }

<<<<<<< HEAD
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
=======
>>>>>>> 592b9d441f68429fc22c8886d2449f919edbe124
    @ApiOperation("Crear ofertas")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/crear")
    public ResponseEntity<?> crearOferta(@RequestBody Oferta oferta){

        ofertaService.registrarOferta(oferta);
        return new ResponseEntity(new Mensaje("Oferta creada"), HttpStatus.CREATED);
    }

    @ApiOperation("Actualizar distintos campos de una oferta")
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarOferta(@PathVariable("id")Long id, @RequestBody Oferta oferta){

        ofertaService.actualizarOferta(id,oferta);
        return new ResponseEntity(new Mensaje("oferta actualizada"), HttpStatus.ACCEPTED);
    }

<<<<<<< HEAD
        ofertaService.actualizarEstado(id,ofertaDto);
        return new ResponseEntity(new Mensaje("El estado de la oferta ha sido actualizado "), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Eliminar oferta por id")
=======
    @ApiOperation("Eliminar una oferta por id")
>>>>>>> 592b9d441f68429fc22c8886d2449f919edbe124
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarOferta(@RequestParam("id")Long id){

        ofertaService.delete(id);
        return new ResponseEntity(new Mensaje("Oferta eliminada"), HttpStatus.OK);
    }









   /* @ApiOperation("Actualizar estado  de una oferta")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/estado/{id}")
    public ResponseEntity<?> actualizarEstadoOferta(@PathVariable("id")Long id, @RequestBody OfertaDto ofertaDto){

        ofertaService.actualizarEstado(id,ofertaDto);
        return new ResponseEntity(new Mensaje("El estado de la oferta ha sido actualizado "), HttpStatus.ACCEPTED);
    }*/


}
