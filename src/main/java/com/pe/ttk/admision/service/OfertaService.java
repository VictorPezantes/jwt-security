package com.pe.ttk.admision.service;

<<<<<<< HEAD
import com.pe.ttk.admision.dto.OfertaDto;
=======
>>>>>>> 592b9d441f68429fc22c8886d2449f919edbe124
import com.pe.ttk.admision.entity.oferta.Oferta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OfertaService {


    List<Oferta> listarOfertas();

    void registrarOferta(Oferta oferta);

    void actualizarOferta(Long id, Oferta oferta);

    void delete(Long id);

    Optional<Oferta> getOne(Long id);

    //void actualizarEstado(Long id, OfertaDto ofertaDto);
}
