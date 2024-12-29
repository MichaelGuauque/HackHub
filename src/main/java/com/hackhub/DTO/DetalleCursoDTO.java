package com.hackhub.DTO;

import com.hackhub.persistence.model.Curso;

public record DetalleCursoDTO(Long id,
                              String nombre,
                              String categoria,
                              Boolean estado) {
    public DetalleCursoDTO (Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.isEstado());
    }
}
