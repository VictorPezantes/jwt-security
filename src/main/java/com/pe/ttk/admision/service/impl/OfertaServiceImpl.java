package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.OfertaDto;
import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.master.Estado;
import com.pe.ttk.admision.entity.oferta.Oferta;
import com.pe.ttk.admision.repository.CargoRepository;
import com.pe.ttk.admision.repository.EstadoRepository;
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
    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    EstadoRepository estadoRepository;

    ConvertirFechas convertirFechas = new ConvertirFechas();

    public List<Oferta> listarOfertas() {
        return ofertaRepository.findAll();
    }

    @Override
    public List<Oferta> listaFiltradaOfertas(String search) {

        return null;
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

    public void actualizarOferta(Long id, OfertaDto ofertaDto) {

        Long idCargo = ofertaDto.getCargoOferta().getId();
        Oferta oferta = getOne(id).get();
        Cargo cargo = cargoRepository.getOne(idCargo);

        oferta.setTitulo(ofertaDto.getTitulo());
        oferta.setDescripcion(ofertaDto.getDescripcion());
        oferta.setRequisito(ofertaDto.getRequisito());
        oferta.setCargoOferta(cargo);
        oferta.setFechaActualización(convertirFechas.stringToDateSql());
        ofertaRepository.save(oferta);
    }


    @Override
    public void actualizarEstadoOferta(Long id, OfertaDto ofertaDto) {

        Long idEstado = ofertaDto.getEstadoOferta().getId();
        Oferta oferta = getOne(id).get();
        Estado estado = estadoRepository.getOne(idEstado);

        if (estado.getEstado().equalsIgnoreCase("ACTIVADA")) {
            oferta.setFechaPublicacion(convertirFechas.stringToDateSql());
            oferta.setEstadoOferta(estado);
            ofertaRepository.save(oferta);
        } else if (estado.getEstado().equalsIgnoreCase("DESACTIVADA")) {
            oferta.setFechaDesactivado(convertirFechas.stringToDateSql());
            oferta.setEstadoOferta(estado);
            ofertaRepository.save(oferta);

        }
    }

    public void delete(Long id) {
        ofertaRepository.deleteById(id);
    }

    public Optional<Oferta> getOne(Long id) {
        return ofertaRepository.findById(id);
    }


}
