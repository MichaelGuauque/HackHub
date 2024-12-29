package com.hackhub.service.interfaces;

import com.hackhub.persistence.model.Curso;

import java.util.List;

public interface ICursoService {

    void save(Curso curso);
    Curso findById(Long id);
    List<Curso> findAll();
    void cambiarEstado(Long id);
    void update(Curso curso);
}
