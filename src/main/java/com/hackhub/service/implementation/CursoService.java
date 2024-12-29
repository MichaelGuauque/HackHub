package com.hackhub.service.implementation;

import com.hackhub.DTO.DetalleCursoDTO;
import com.hackhub.DTO.RegistrarCursoDTO;
import com.hackhub.persistence.model.Curso;
import com.hackhub.persistence.repository.CursoRepository;
import com.hackhub.service.interfaces.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Curso> findByEstadoTrue(Pageable pageable) {
        return cursoRepository.findByEstadoTrue(pageable);
    }

    @Override
    public void cambiarEstado(Long id) {
        Curso curso = findById(id);
        curso.setEstado(false);
//        cursoRepository.save(curso);
    }

    @Override
    public void update(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public Curso cambiarRegistroDTO(RegistrarCursoDTO cursoDTO) {
        return new Curso(null, cursoDTO.nombre(),
                cursoDTO.categoria(), true);
    }

    @Override
    public Curso cambiarDetalleDTO(DetalleCursoDTO detalleCursoDTO) {
        Curso curso = findById(detalleCursoDTO.id());
        curso.actualizarDatos(detalleCursoDTO);
        return new Curso(detalleCursoDTO.id(), detalleCursoDTO.nombre(), detalleCursoDTO.categoria(), detalleCursoDTO.estado());
    }
}
