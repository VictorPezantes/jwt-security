package com.pe.ttk.admision.service;


import com.pe.ttk.admision.entity.Postulante;
import com.pe.ttk.admision.repository.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostulanteService {

    @Autowired
    PostulanteRepository postulanteRepository;

    public List<Postulante> list(){
        return postulanteRepository.findAll();
    }



    public List<Postulante> findByEstadoPostulacion(String estadoPostulacion){

        return postulanteRepository.findByEstadoPostulacion(estadoPostulacion);
    };

    public Optional<Postulante> findByPrimerNombre(String primerNombre){

        return postulanteRepository.findByPrimerNombre(primerNombre);
    };

    public void  save(Postulante postulante){
        postulanteRepository.save(postulante);
    }

    public void delete(int id){
        postulanteRepository.deleteById(id);
    }

    public Optional<Postulante> getOne(int id){
        return postulanteRepository.findById(id);
    }

}
