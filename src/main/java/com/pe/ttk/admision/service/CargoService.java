package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.CargoDto;
import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.oferta.Oferta;

import java.util.List;
import java.util.Optional;

public interface CargoService {

    List<Cargo> listaCargos();
    void registrarCargo(Cargo cargo);

    void eliminarCargo(Long id);

    void actualizarCargo(Long id, Cargo cargo);

    Optional<Cargo> getOne(Long id);
}
