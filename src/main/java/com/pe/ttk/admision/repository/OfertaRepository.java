package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.Oferta;
import com.pe.ttk.admision.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {


    List<Oferta> findAll();
    List<Oferta> findByEstado(String estado);
    List<Oferta> findByFechaPublicacion(Date fechaPublicacion);
    Optional<Oferta> findByTitulo(String titulo);
    List<Oferta> findByCreador(String creador);
}
