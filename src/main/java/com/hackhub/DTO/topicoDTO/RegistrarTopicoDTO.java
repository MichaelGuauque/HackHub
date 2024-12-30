package com.hackhub.DTO.topicoDTO;

import com.hackhub.persistence.model.Curso;
import com.hackhub.persistence.model.Usuario;

public record RegistrarTopicoDTO(
        String titulo,
        String mensaje,
        Usuario autor,
        Curso curso
) {
}
