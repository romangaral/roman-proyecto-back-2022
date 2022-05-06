package com.daw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daw.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {

	List<Rol> findByTipo(String tipo);
}
