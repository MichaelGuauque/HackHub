package com.hackhub.service.interfaces;

import com.hackhub.persistence.model.Topico;

import java.util.List;

public interface ITopicoService {

    void save(Topico topico);
    List<Topico> findAll();
    Topico findById(Long id);
    void cambiarEstado(Long id);
    void actualizar(Topico topico);
}
