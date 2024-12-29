package com.hackhub.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contrasenia;

    private List<Topico> topicos;
    private List<Respuesta> respuestas;
}
