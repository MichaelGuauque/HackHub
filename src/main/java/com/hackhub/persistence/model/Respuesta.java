package com.hackhub.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    private Long id;
    private String mensaje;
    private Topico topico;
    private LocalDateTime fechaDeCreacion;
    private Usuario author;
    private String solucion;
}
