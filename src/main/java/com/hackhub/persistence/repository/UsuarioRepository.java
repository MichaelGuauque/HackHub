package com.hackhub.persistence.repository;

import com.hackhub.persistence.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
