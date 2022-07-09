package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.entity.master.Estado;
import com.pe.ttk.admision.repository.EncargadoRepository;
import com.pe.ttk.admision.service.EncargadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EncargadoServieImp implements EncargadoService {

    @Autowired
    private EncargadoRepository encargadoRepository;

    @Override
    public List<Encargado> listaEncargados() {
        return encargadoRepository.findAll();
    }

    public void registrarEncargado(Encargado encargado) {


        encargadoRepository.save(encargado);
    }

    @Override
    public void eliminarEncargado(Long id) {
        encargadoRepository.deleteById(id);
    }

    @Override
    public void actualizarEncargado(Long id, Encargado encargado) {
        encargado.setId(id);
        encargadoRepository.save(encargado);
    }

    @Override
    public Optional<Encargado> getOne(Long id) {
        return encargadoRepository.findById( id);
    }
}
