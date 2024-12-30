package com.hackhub.DTO.topicoDTO;

import com.hackhub.persistence.model.Topico;
import com.hackhub.persistence.model.Usuario;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetalleTopicoDTO(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @AssertTrue
        boolean estado,
        @FutureOrPresent
        LocalDateTime fechaCreacion,
        Usuario autor,
        Topico topico
) {
}
