package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.entity.master.Estado;
import com.pe.ttk.admision.service.impl.CargoServieImp;
import com.pe.ttk.admision.service.impl.EncargadoServieImp;
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
@RequestMapping("/encargado")
@CrossOrigin(origins = "http://localhost:4200")
public class EncargadoController {

    @Autowired
    EncargadoServieImp encargadoServieImp;

    @ApiOperation("Lista todos los encargados registrado y paginacion")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/lista", produces = "application/json")
    public String  listarEncargado(@RequestParam(value = "numpagina") Integer page,
                                              @RequestParam(value = "size") Integer size,
                                              Model model) {
        List<Encargado> listaEncargados = encargadoServieImp.listaEncargados();

        return PaginationUtils.getPaginationedResults(listaEncargados, page, size, model);


    }
        @ApiOperation("Registrar encargado")
        @PreAuthorize("hasRole('ADMIN')")
        @PutMapping(value = "/registrar", produces = "application/json")
        public ResponseEntity<?>  registrarEncargado(@RequestBody Encargado encargado){

            encargadoServieImp.registrarEncargado(encargado);
            return new ResponseEntity(new Mensaje("encargado registrado correctamente"), HttpStatus.CREATED);
        }

    @ApiOperation("Eliminar un encargado por id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/eliminar", produces = "application/json")
    public ResponseEntity<?> eliminarEncargado(@RequestParam("id") Long id) {

        encargadoServieImp.eliminarEncargado(id);
        return new ResponseEntity(new Mensaje("Encargado eliminado"), HttpStatus.OK);
    }

    @ApiOperation("Actualizar distintos campos de un encargado")
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping(value = "/actualizar/{id}", produces = "application/json")
    public ResponseEntity<?> actualizarEncargado(@PathVariable("id") Long id, @RequestBody Encargado encargado) {

        encargadoServieImp.actualizarEncargado(id, encargado);
        return new ResponseEntity(new Mensaje("encargado actualizado"), HttpStatus.ACCEPTED);
    }
    }












