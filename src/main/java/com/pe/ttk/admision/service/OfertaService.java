package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.entity.oferta.Oferta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OfertaService {


    List<Oferta> listarOfertas();

    List<Oferta> listaFiltradaOfertas(String search);

    void registrarOferta(Oferta oferta);

    void actualizarOferta(Long id, OfertaDto ofertaDto);
    void actualizarEstadoOferta(Long id, OfertaDto ofertaDto);

    void delete(Long id);

    Optional<Oferta> getOne(Long id);


}
