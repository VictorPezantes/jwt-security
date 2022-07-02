package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.Oferta;
import com.pe.ttk.admision.entity.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulante,Integer> {


    List<Postulante> findAll();
    List<Postulante> findByEstadoPostulacion(String estadoPostulacion);
    Optional<Postulante> findByPrimerNombre(String primerNombre);
}
