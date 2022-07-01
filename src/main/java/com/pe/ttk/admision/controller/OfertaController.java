package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.entity.Oferta;
import com.pe.ttk.admision.service.OfertaService;
import com.pe.ttk.admision.util.ConvertFecha;
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
@RequestMapping("/oferta")
@CrossOrigin(origins = "http://localhost:4200")
public class OfertaController {

    @Autowired
   OfertaService ofertaService;

    ConvertFecha convertFecha = new ConvertFecha();

    @ApiOperation("Lista todas las ofertas creadas")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista")
    public ResponseEntity<List<Oferta>> list(){
        List<Oferta> list = ofertaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @ApiOperation("Lista las ofertas filtradas por su estado")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista/estados/{estado}")
    public ResponseEntity<Oferta> obtenerOfertaPorEstado(@PathVariable("estado") String estado){

        List<Oferta> oferta = ofertaService.findByEstado(estado);
        return new ResponseEntity(oferta, HttpStatus.OK);
    }
    @ApiOperation("Lista las ofertas creadas por un usuario específico")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista/creador/{creador}")
    public ResponseEntity<Oferta> obtenerOfertaPorCreador(@PathVariable("creador") String creador){

        List<Oferta> oferta = ofertaService.findByCreador(creador);
        return new ResponseEntity(oferta, HttpStatus.OK);
    }
    @ApiOperation("Muestra una oferta buscada por su título")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista/titulo/{titulo}")
    public ResponseEntity<Oferta> obtenerOfertaPorTítulo(@PathVariable("titulo") String titulo){
        Optional<Oferta> oferta = ofertaService.findByTitulo(titulo);
        return new ResponseEntity(oferta, HttpStatus.OK);
    }
    @ApiOperation("Lista las ofertas por fecha de Publicación")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista/fechapublicacion/{fechaPublicacion}")
    public ResponseEntity<Oferta> obetenerOfertaPorFechaPublicacion(@PathVariable("fechaPublicacion") Date fechaPublicacion){

        List<Oferta> oferta = ofertaService.findByFechaPublicacion(fechaPublicacion);
        return new ResponseEntity(oferta, HttpStatus.OK);
    }
    @ApiOperation("Crear ofertas")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearOferta(@RequestBody OfertaDto ofertaDto){

       Date fechaCreacion= Date.valueOf(ofertaDto.getFechaCreacion());
       Date fechaPublicacion;

       if(ofertaDto.getFechaPublicacion().isEmpty()) {
           fechaPublicacion = null;
       }else{
           fechaPublicacion =Date.valueOf(ofertaDto.getFechaPublicacion());
       }
        Oferta oferta = new Oferta(ofertaDto.getEstado(),ofertaDto.getTitulo(),ofertaDto.getDescripcion(),ofertaDto.getRequisito(),ofertaDto.getCreador(),fechaCreacion
                ,fechaPublicacion,ofertaDto.getCargoPostular(),ofertaDto.getCantidadPostulantes());
        ofertaService.save(oferta);
        return new ResponseEntity(new Mensaje("Oferta creada"), HttpStatus.CREATED);
    }
    @ApiOperation("Actualizar distintos campos de una oferta")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarOferta(@PathVariable("id")int id, @RequestBody OfertaDto ofertaDto){

        Date fechaCreacion;
        if(ofertaDto.getFechaCreacion().isEmpty()) {
            fechaCreacion = null;
        }else{
            fechaCreacion =Date.valueOf(ofertaDto.getFechaCreacion());
        }

        Date fechaPublicacion;

        if(ofertaDto.getFechaPublicacion()==null) {
            fechaPublicacion = null;
        }else{
            fechaPublicacion =Date.valueOf(ofertaDto.getFechaPublicacion());
        }
        Oferta oferta = ofertaService.getOne(id).get();
        oferta.setEstado(ofertaDto.getEstado());
        oferta.setCantidadPostulantes(ofertaDto.getCantidadPostulantes());
        oferta.setCargoPostular(ofertaDto.getCargoPostular());
        oferta.setCreador(ofertaDto.getCreador());
        oferta.setFechaPublicacion(fechaCreacion);
        oferta.setFechaCreacion(fechaPublicacion);
        oferta.setDescripcion(oferta.getDescripcion());
        oferta.setRequisito(ofertaDto.getRequisito());
        oferta.setTitulo(ofertaDto.getTitulo());
        ofertaService.save(oferta);
        return new ResponseEntity(new Mensaje("oferta actualizada"), HttpStatus.ACCEPTED);
    }

}
