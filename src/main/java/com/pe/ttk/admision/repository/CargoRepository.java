package com.pe.ttk.admision.repository;


import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.master.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {


}
