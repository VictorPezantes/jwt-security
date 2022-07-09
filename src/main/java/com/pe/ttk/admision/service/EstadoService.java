package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.master.Estado;

import java.util.List;
import java.util.Optional;

public interface EstadoService {

    List<Estado> listaEstados();

    void registrarEstado(Estado estado);

    void eliminarEstado(Long id);

    void actualizarEstado(Long id, Estado estado);

    Optional<Estado> getOne(Long id);
}
