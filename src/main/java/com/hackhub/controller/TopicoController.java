package com.hackhub.controller;

import com.hackhub.DTO.topicoDTO.RegistrarTopicoDTO;
import com.hackhub.DTO.topicoDTO.DetalleTopicoDTO;
import com.hackhub.persistence.model.Topico;
import com.hackhub.service.interfaces.ITopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ITopicoService topicoService;

    public ResponseEntity<DetalleTopicoDTO> guardarTopico (@RequestBody RegistrarTopicoDTO registrarTopicoDTO,
                                                           UriComponentsBuilder uriBuilder) {
        Topico topico = topicoService.cambiarRegistroTopicoDTO(registrarTopicoDTO);
        topicoService.save(topico);

        return ResponseEntity.ok().build();
    }
}
