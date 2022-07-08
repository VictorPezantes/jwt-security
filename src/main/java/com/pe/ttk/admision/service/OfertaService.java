package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.entity.oferta.Oferta;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface OfertaService {


    List<Oferta> listarOfertas();

    List<Oferta> findByEstado(String estado);

    List<Oferta> findByFechaPublicacion(Date fechaPublicacion);

    Optional<Oferta> findByTitulo(String titulo);

    List<Oferta> findByCreador(String creador);

    void registrarOferta(OfertaDto ofertaDto);
    void actualizarOferta(int id, OfertaDto ofertaDto);

    void actualizarEstado(int id, OfertaDto ofertaDto);

    void delete(int id);

    Optional<Oferta> getOne(int id);
}
