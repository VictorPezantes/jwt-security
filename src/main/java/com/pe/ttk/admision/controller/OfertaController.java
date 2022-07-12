package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.entity.oferta.Oferta;
import com.pe.ttk.admision.service.impl.OfertaServiceImpl;
import com.pe.ttk.admision.util.PaginationUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oferta")
@CrossOrigin(origins = "http://localhost:4200")
public class OfertaController {

    @Autowired
    OfertaServiceImpl ofertaService;


    @ApiOperation("Lista todas las ofertas creadas")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/lista", produces = "application/json")
    public String listarOfertas(@RequestParam(value = "numpagina") Integer page,
                                @RequestParam(value = "size") Integer size,
                                Model model) {
        List<Oferta> listaOfertas = ofertaService.listarOfertas();

        return PaginationUtils.getPaginationedResults(listaOfertas, page, size, model);
    }


    @ApiOperation("Crear ofertas")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/crear")
    public ResponseEntity<?> crearOferta(@RequestBody Oferta oferta, Authentication auth) {

        ofertaService.registrarOferta(oferta,auth);
        return new ResponseEntity(new Mensaje("Oferta creada"), HttpStatus.CREATED);
    }

    @ApiOperation("Actualizar distintos campos de una oferta")
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarOferta(@PathVariable("id") Long id, @RequestBody OfertaDto ofertaDto) {

        ofertaService.actualizarOferta(id, ofertaDto);
        return new ResponseEntity(new Mensaje("oferta actualizada"), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar estado de una oferta")
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/actualizar/estado/{id}")
    public ResponseEntity<?> actualizarEstadoOferta(@PathVariable("id") Long id, @RequestBody OfertaDto ofertaDto) {

        ofertaService.actualizarEstadoOferta(id, ofertaDto);
        return new ResponseEntity(new Mensaje("oferta actualizada"), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Eliminar una oferta por id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarOferta(@RequestParam("id") Long id) {

        ofertaService.delete(id);
        return new ResponseEntity(new Mensaje("Oferta eliminada"), HttpStatus.OK);
    }
}