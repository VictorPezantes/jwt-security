package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.entity.Oferta;
import com.pe.ttk.admision.repository.OfertaRepository;
import com.pe.ttk.admision.service.OfertaService;
import com.pe.ttk.admision.util.ConvertirFechas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfertaServiceImpl implements OfertaService {


    @Autowired
    OfertaRepository ofertaRepository;

    Oferta oferta = new Oferta();

    ConvertirFechas convertirFechas = new ConvertirFechas();

    public List<Oferta> listarOfertas(){
        return ofertaRepository.findAll();
    }

    public List<Oferta> findByEstado(String estado){

        return ofertaRepository.findByEstadoIgnoreCase(estado);
    };

    public List<Oferta> findByFechaPublicacion(Date fechaPublicacion){

        return ofertaRepository.findByFechaPublicacion(fechaPublicacion);
    };

    public Optional<Oferta> findByTitulo(String titulo){
        return ofertaRepository.findByTituloIgnoreCase(titulo);
    };
    public List<Oferta> findByCreador(String creador){
        return ofertaRepository.findByCreadorIgnoreCase(creador);
    };

    public void  registrarOferta(OfertaDto ofertaDto){

        oferta.setEstado(ofertaDto.getEstado());
        oferta.setCantidadPostulantes(ofertaDto.getCantidadPostulantes());
        oferta.setCargoPostular(ofertaDto.getCargoPostular());
        oferta.setCreador(ofertaDto.getCreador());
        oferta.setFechaPublicacion(null);
        oferta.setFechaCreacion(convertirFechas.stringToDateSql());
        oferta.setDescripcion(ofertaDto.getDescripcion());
        oferta.setRequisito(ofertaDto.getRequisito());
        oferta.setTitulo(ofertaDto.getTitulo());
        oferta.setFechaActualización(null);
        oferta.setFechaDesactivado(null);
        ofertaRepository.save(oferta);
    }

    public void actualizarOferta(int id, OfertaDto ofertaDto){

        oferta.setCargoPostular(ofertaDto.getCargoPostular());
        oferta.setDescripcion(ofertaDto.getDescripcion());
        oferta.setRequisito(ofertaDto.getRequisito());
        oferta.setTitulo(ofertaDto.getTitulo());
        oferta.setFechaActualización(convertirFechas.stringToDateSql());
    }

    @Override
    public void actualizarEstado(int id, OfertaDto ofertaDto) {

        Oferta oferta = getOne(id).get();

        if(ofertaDto.getEstado().equalsIgnoreCase("activada")){
            oferta.setEstado(ofertaDto.getEstado());
            oferta.setFechaPublicacion(convertirFechas.stringToDateSql());
        }else if(ofertaDto.getEstado().equalsIgnoreCase("desactivada")){
            oferta.setEstado(ofertaDto.getEstado());
            oferta.setFechaDesactivado(convertirFechas.stringToDateSql());
        }

    }

    public void delete(int id){
        ofertaRepository.deleteById(id);
    }

    public Optional<Oferta> getOne(int id){
        return ofertaRepository.findById(id);
    }
}
