package com.hackhub.DTO.cursoDTO;

import jakarta.validation.constraints.NotBlank;

public record RegistrarCursoDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria) {
}
