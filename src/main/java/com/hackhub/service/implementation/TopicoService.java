package com.hackhub.service.implementation;

import com.hackhub.DTO.topicoDTO.RegistrarTopicoDTO;
import com.hackhub.persistence.model.Curso;
import com.hackhub.persistence.model.Topico;
import com.hackhub.persistence.model.Usuario;
import com.hackhub.persistence.repository.CursoRepository;
import com.hackhub.persistence.repository.TopicoRepository;
import com.hackhub.persistence.repository.UsuarioRepository;
import com.hackhub.service.interfaces.ITopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService implements ITopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void save(Topico topico) {
        topicoRepository.save(topico);
    }

    @Override
    public List<Topico> findAll() {
        return (List<Topico>) topicoRepository.findAll();
    }

    @Override
    public Page<Topico> findByEstadoTrue(Pageable pageable) {
        return topicoRepository.findByEstadoTrue(pageable);
    }

    @Override
    public Topico findById(Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if(topicoOptional.isPresent()){
            return topicoOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Topico no encontrado");
    }


    @Override
    public void cambiarEstado(Long id) {
        Topico topico = findById(id);
        topico.setEstado(false);
    }

    @Override
    public void update(Topico topico) {
        topicoRepository.save(topico);
    }

    @Override
    public Topico cambiarRegistroTopicoDTO(RegistrarTopicoDTO registrarTopicoDTO) {
        Usuario usuario = usuarioService.findById(registrarTopicoDTO.autor());
        Curso curso = cursoService.findById(registrarTopicoDTO.curso());
        return new Topico(null, registrarTopicoDTO.titulo(), registrarTopicoDTO.mensaje(),
                LocalDateTime.now(), true, usuario, curso);
    }

    @Override
    public Topico cambiarRegistroActualizarTopicoDTO(Long id, RegistrarTopicoDTO registrarTopicoDTO) {
        Topico topico = findById(id);
        topico.setTitulo(registrarTopicoDTO.titulo());
        topico.setMensaje(registrarTopicoDTO.mensaje());
        topico.setAutor(usuarioService.findById(registrarTopicoDTO.autor()));
        topico.setCurso(cursoService.findById(registrarTopicoDTO.curso()));
        return topico;
    }

    @Override
    public boolean estaPresente(Long id) {
        return topicoRepository.existsById(id);
    }
}
