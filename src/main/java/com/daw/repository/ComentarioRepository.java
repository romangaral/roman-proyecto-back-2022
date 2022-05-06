package com.daw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daw.model.Comentario;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {

}
