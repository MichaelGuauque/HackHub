package com.hackhub.service.implementation;

import com.hackhub.DTO.respuestaDTO.RegistroRespuestaDTO;
import com.hackhub.persistence.model.Respuesta;
import com.hackhub.persistence.model.Topico;
import com.hackhub.persistence.model.Usuario;
import com.hackhub.persistence.repository.RespuestaRepository;
import com.hackhub.service.interfaces.IRespuestaservice;
import com.hackhub.service.interfaces.ITopicoService;
import com.hackhub.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService implements IRespuestaservice {

    @Autowired
    private RespuestaRepository respuestaRepository;

    private IUsuarioService usuarioService;

    private ITopicoService topicoService;

    @Override
    public void save(Respuesta respuesta) {
        respuestaRepository.save(respuesta);
    }

    @Override
    public void update(Respuesta respuesta) {
        respuestaRepository.save(respuesta);
    }

    @Override
    public Respuesta findById(Long id) {
        Optional<Respuesta> repuestaOptional = respuestaRepository.findById(id);
        if(repuestaOptional.isPresent()){
            return repuestaOptional.get();
        }
        throw new RuntimeException("Respuesta no encontrada");
    }

    @Override
    public List<Respuesta> findAll() {
        return (List<Respuesta>) respuestaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        respuestaRepository.deleteById(id);
    }

    @Override
    public Respuesta cambiarRegistroRespuestaDTO(RegistroRespuestaDTO registroRespuestaDTO) {
        Usuario usuario = usuarioService.findById(registroRespuestaDTO.autor());
        Topico topico = topicoService.findById(registroRespuestaDTO.topico());
        return new Respuesta(null, registroRespuestaDTO.mensaje(), LocalDateTime.now(),
                registroRespuestaDTO.solucion(), usuario, topico);
    }

    @Override
    public boolean estaPresente(Long id) {
        return respuestaRepository.existsById(id);
    }

    @Override
    public Respuesta cambiarRegistroActualizarRespuestaDTO(Long id, RegistroRespuestaDTO registroRespuestaDTO) {
        Respuesta respuesta = findById(id);
        respuesta.setMensaje(registroRespuestaDTO.mensaje());
        respuesta.setSolucion(registroRespuestaDTO.solucion());
        respuesta.setAutor(usuarioService.findById(registroRespuestaDTO.autor()));
        respuesta.setTopico(topicoService.findById(registroRespuestaDTO.topico()));
        return respuesta;
    }
}
