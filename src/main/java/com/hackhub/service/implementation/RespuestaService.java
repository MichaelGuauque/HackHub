package com.hackhub.service.implementation;

import com.hackhub.persistence.model.Respuesta;
import com.hackhub.persistence.model.Topico;
import com.hackhub.persistence.repository.RespuestaRepository;
import com.hackhub.service.interfaces.IRespuestaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService implements IRespuestaservice {

    @Autowired
    private RespuestaRepository respuestaRepository;

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
}
