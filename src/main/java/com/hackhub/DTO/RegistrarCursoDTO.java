package com.hackhub.DTO;

import jakarta.validation.constraints.NotBlank;

public record RegistrarCursoDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria) {
}
