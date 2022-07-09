package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.master.Estado;
import com.pe.ttk.admision.service.impl.EstadoServiceImp;
import com.pe.ttk.admision.util.PaginationUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {

    @Autowired
    EstadoServiceImp estadoServiceImp;

    @ApiOperation("Lista todos los estados de las  ofertas y su paginacion")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/lista", produces = "application/json")
    public String listarEstados(@RequestParam(value = "numpagina") Integer page,
                                @RequestParam(value = "size") Integer size,
                                Model model) {
        List<Estado> listaEstados = estadoServiceImp.listaEstados();

        return PaginationUtils.getPaginationedResults(listaEstados, page, size, model);

    }

    @ApiOperation("Registrar estado")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/registrar", produces = "application/json")
    public ResponseEntity<?> registrarEstado(@RequestBody Estado estado) {

        estadoServiceImp.registrarEstado(estado);
        return new ResponseEntity(new Mensaje("estado registrado correctamente"), HttpStatus.CREATED);
    }

    @ApiOperation("Eliminar un estado por id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/eliminar", produces = "application/json")
    public ResponseEntity<?> eliminarEstado(@RequestParam("id") Long id) {

        estadoServiceImp.eliminarEstado(id);
        return new ResponseEntity(new Mensaje("Estado eliminado"), HttpStatus.OK);
    }

    @ApiOperation("Actualizar distintos campos de un estado")
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping(value = "/actualizar/{id}", produces = "application/json")
    public ResponseEntity<?> actualizarEstado(@PathVariable("id") Long id, @RequestBody Estado estado) {

        estadoServiceImp.actualizarEstado(id, estado);
        return new ResponseEntity(new Mensaje("estado actualizado"), HttpStatus.ACCEPTED);
    }
}












