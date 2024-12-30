package com.hackhub.service.interfaces;

import com.hackhub.DTO.topicoDTO.RegistrarTopicoDTO;
import com.hackhub.persistence.model.Curso;
import com.hackhub.persistence.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITopicoService {

    void save(Topico topico);
    List<Topico> findAll();
    Page<Topico> findByEstadoTrue(Pageable pageable);
    Topico findById(Long id);
    void cambiarEstado(Long id);
    void update(Topico topico);
    Topico cambiarRegistroTopicoDTO(RegistrarTopicoDTO registrarTopicoDTO);
}
