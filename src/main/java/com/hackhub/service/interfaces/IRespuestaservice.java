package com.hackhub.service.interfaces;

import com.hackhub.persistence.model.Respuesta;

import java.util.List;

public interface IRespuestaservice {

    void save(Respuesta respuesta);
    void update(Respuesta respuesta);
    Respuesta findById(Long id);
    List<Respuesta> findAll();
}