package com.hackhub.persistence.repository;

import com.hackhub.persistence.model.Respuesta;
import com.hackhub.persistence.model.Topico;
import com.hackhub.persistence.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {
    List<Respuesta> findByTopico(Topico topico);
}
