package com.hackhub.service.implementation;

import com.hackhub.persistence.model.Curso;
import com.hackhub.persistence.repository.CursoRepository;
import com.hackhub.service.interfaces.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void save(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public Curso findById(Long id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if(cursoOptional.isPresent()){
            return cursoOptional.get();
        }
        throw new RuntimeException("Curso no encontrado");
    }

    @Override
    public List<Curso> findAll() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    public void cambiarEstado(Long id) {
        Curso curso = findById(id);
        curso.setEstado(false);
        cursoRepository.save(curso);
    }

    @Override
    public void update(Curso curso) {
        cursoRepository.save(curso);
    }
}
