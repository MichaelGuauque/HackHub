package com.hackhub.DTO.topicoDTO;

import com.hackhub.DTO.UsuarioDTO.DetalleUsuarioDTO;
import com.hackhub.DTO.cursoDTO.DetalleCursoDTO;
import com.hackhub.DTO.respuestaDTO.DetalleRespuestaDTO;
import com.hackhub.persistence.model.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DetalleTopicoConRespuestaDTO(
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
        @NotBlank
        @Valid
        DetalleUsuarioDTO autor,
        @NotBlank
        @Valid
        DetalleCursoDTO curso,
        List<DetalleRespuestaDTO> respuestas
) {
    public DetalleTopicoConRespuestaDTO(Topico topico, List<DetalleRespuestaDTO> respuestas) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.isEstado(), topico.getFechaCreacion(),
                new DetalleUsuarioDTO(topico.getAutor()),
                new DetalleCursoDTO(topico.getCurso()),
                respuestas);
    }
}