package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.entity.oferta.Oferta;
import com.pe.ttk.admision.repository.OfertaRepository;
import com.pe.ttk.admision.service.OfertaService;
import com.pe.ttk.admision.util.ConvertirFechas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfertaServiceImpl implements OfertaService {


    @Autowired
    OfertaRepository ofertaRepository;

    ConvertirFechas convertirFechas = new ConvertirFechas();

    public List<Oferta> listarOfertas() {
        return ofertaRepository.findAll();
    }

    public void registrarOferta(Oferta oferta) {

        oferta.setEstadoOferta(oferta.getEstadoOferta());
        oferta.setCantidadPostulantes(oferta.getCantidadPostulantes());
        oferta.setCargoOferta(oferta.getCargoOferta());
        oferta.setCreadorOferta(oferta.getCreadorOferta());
        oferta.setFechaPublicacion(null);
        oferta.setFechaCreacion(convertirFechas.stringToDateSql());
        oferta.setDescripcion(oferta.getDescripcion());
        oferta.setRequisito(oferta.getRequisito());
        oferta.setTitulo(oferta.getTitulo());
        oferta.setFechaActualización(null);
        oferta.setFechaDesactivado(null);
        ofertaRepository.save(oferta);
    }

    public void actualizarOferta(Long id, Oferta oferta) {

        oferta.setId(id);
        oferta.setFechaActualización(convertirFechas.stringToDateSql());
        ofertaRepository.save(oferta);


    }

    public void delete(Long id) {
        ofertaRepository.deleteById(id);
    }

    public Optional<Oferta> getOne(Long id) {
        return ofertaRepository.findById(id);
    }


    /* @Override
    public void actualizarEstado(Long id, Oferta oferta) {
        oferta.setId(id);
        if(oferta.getEstadoOferta().getEstado().equalsIgnoreCase("activada")){
            oferta.setEstado(null);
            oferta.setFechaPublicacion(convertirFechas.stringToDateSql());
        }else if(ofertaDto.getEstado().equalsIgnoreCase("desactivada")){
            oferta.setEstado(null);
            oferta.setFechaDesactivado(convertirFechas.stringToDateSql());
        }
    }*/
}