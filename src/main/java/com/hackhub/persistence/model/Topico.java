package com.hackhub.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;
    private boolean estado;
    private Usuario autor;
    private Curso curso;
    private List<Respuesta> respuestas;
}
