package com.hackhub.controller;

import com.hackhub.DTO.respuestaDTO.DetalleRespuestaDTO;
import com.hackhub.DTO.respuestaDTO.RegistroRespuestaDTO;
import com.hackhub.persistence.model.Respuesta;
import com.hackhub.service.interfaces.IRespuestaservice;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private IRespuestaservice respuestaservice;

    @PostMapping
    public ResponseEntity<DetalleRespuestaDTO> guardarRespuesta(@RequestBody @Valid RegistroRespuestaDTO registroRespuestaDTO,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Respuesta respuesta = respuestaservice.cambiarRegistroRespuestaDTO(registroRespuestaDTO);
        respuestaservice.save(respuesta);
        URI url = uriComponentsBuilder.path("/respuestas/{id}").build(respuesta.getId());
        return ResponseEntity.created(url).body(new DetalleRespuestaDTO(respuesta));
    }

    @GetMapping
    public ResponseEntity<List<DetalleRespuestaDTO>> listarRespuestas() {
        return ResponseEntity.ok(respuestaservice.findAll().stream().map(DetalleRespuestaDTO::new).toList());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalleRespuestaDTO> modificarRespuesta(@PathVariable Long id, @RequestBody @Valid RegistroRespuestaDTO registroRespuestaDTO){
        if(respuestaservice.estaPresente(id)){
            Respuesta respuesta = respuestaservice.cambiarRegistroActualizarRespuestaDTO(id, registroRespuestaDTO);
            respuestaservice.update(respuesta);
            return ResponseEntity.ok(new DetalleRespuestaDTO(respuesta));
        }
        throw new EntityNotFoundException();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        respuestaservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
