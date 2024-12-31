package com.hackhub.DTO.topicoDTO;

import com.hackhub.DTO.UsuarioDTO.DetalleUsuarioDTO;
import com.hackhub.DTO.cursoDTO.DetalleCursoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarTopicoDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        long autor,
        @NotNull
        long curso
) {
}
