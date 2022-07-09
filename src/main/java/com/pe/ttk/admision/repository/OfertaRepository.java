package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.oferta.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {




    List<Oferta> findByFechaPublicacion(Date fechaPublicacion);
    Optional<Oferta> findByTituloIgnoreCase(String titulo);
    //List<Oferta> findByCreadorIgnoreCase(String creador);
}
