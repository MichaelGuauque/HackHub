package com.hackhub.persistence.repository;

import com.hackhub.persistence.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
    Page<Curso> findByEstadoTrue(Pageable pageable);
}
