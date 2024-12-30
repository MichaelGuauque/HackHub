package com.hackhub.DTO;

import com.hackhub.persistence.model.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalleCursoDTO(
        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String categoria,
        @NotBlank
        Boolean estado) {
    public DetalleCursoDTO (Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.isEstado());
    }
}
