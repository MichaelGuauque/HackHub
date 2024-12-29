package com.hackhub.persistence.repository;

import com.hackhub.persistence.model.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
