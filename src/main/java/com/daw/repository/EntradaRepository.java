package com.daw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daw.model.Entrada;

@Repository
public interface EntradaRepository extends CrudRepository<Entrada, Long>{

}
