package com.hackhub.service.implementation;

import com.hackhub.persistence.model.Topico;
import com.hackhub.persistence.repository.TopicoRepository;
import com.hackhub.service.interfaces.ITopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService implements ITopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void save(Topico topico) {
        topicoRepository.save(topico);
    }

    @Override
    public List<Topico> findAll() {
        return (List<Topico>) topicoRepository.findAll();
    }

    @Override
    public Topico findById(Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if(topicoOptional.isPresent()){
            return topicoOptional.get();
        }
        throw new RuntimeException("Tema no encontrado");
    }


    @Override
    public void cambiarEstado(Long id) {
        Topico topico = findById(id);
//        topico.setEstado(false);
        topicoRepository.save(topico);
    }

    @Override
    public void actualizar(Topico topico) {
        topicoRepository.save(topico);
    }
}
