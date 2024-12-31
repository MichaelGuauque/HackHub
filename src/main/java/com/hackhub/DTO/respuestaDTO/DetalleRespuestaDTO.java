package com.hackhub.DTO.respuestaDTO;

import com.hackhub.DTO.UsuarioDTO.DetalleUsuarioDTO;
import com.hackhub.DTO.topicoDTO.DetalleTopicoDTO;
import com.hackhub.persistence.model.Respuesta;

import java.time.LocalDateTime;

public record DetalleRespuestaDTO(Long id,
                                  String mensaje,
                                  String solucion,
                                  LocalDateTime fechaDeCreacion,
                                  DetalleUsuarioDTO autor,
                                  DetalleTopicoDTO topico) {
    public DetalleRespuestaDTO(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getSolucion(), respuesta.getFechaDeCreacion(),
                new DetalleUsuarioDTO(respuesta.getAutor()), new DetalleTopicoDTO(respuesta.getTopico()));
    }
}
