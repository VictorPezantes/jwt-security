package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.Oferta;
import com.pe.ttk.admision.repository.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfertaService {

    @Autowired
    OfertaRepository  ofertaRepository;

    public List<Oferta> list(){
        return ofertaRepository.findAll();
    }

    public List<Oferta> findByEstado(String estado){

        return ofertaRepository.findByEstado(estado);
    };

    public List<Oferta> findByFechaPublicacion(Date fechaPublicacion){

        return ofertaRepository.findByFechaPublicacion(fechaPublicacion);
    };

    public Optional<Oferta> findByTitulo(String titulo){
        return ofertaRepository.findByTitulo(titulo);
    };
    public List<Oferta> findByCreador(String creador){
        return ofertaRepository.findByCreador(creador);
    };

    public void  save(Oferta oferta){
        ofertaRepository.save(oferta);
    }

    public void delete(int id){
        ofertaRepository.deleteById(id);
    }

    public Optional<Oferta> getOne(int id){
        return ofertaRepository.findById(id);
    }

}
