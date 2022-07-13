package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.entity.master.Estado;
import com.pe.ttk.admision.entity.oferta.Oferta;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface OfertaService {


    List<Oferta> listarOfertas();


    void registrarOferta(Oferta oferta, Authentication auth);

    void actualizarOferta(Long id, OfertaDto ofertaDto);
    void actualizarEstadoOferta(Long id, OfertaDto ofertaDto);

    void delete(Long id);

    Optional<Oferta> getOne(Long id);

    public List<Oferta> findOfertaByQueryString(String titulo);
    List<Oferta> findByCreadorOferta(Encargado creador);

    List<Oferta> findByfechaPublicacion(Date fechaPublicacion);


}
