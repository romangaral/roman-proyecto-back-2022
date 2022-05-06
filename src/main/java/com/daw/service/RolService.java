package com.daw.service;

import java.util.List;
import java.util.Optional;

import com.daw.model.Rol;
import com.daw.repository.RolRepository;

public interface RolService {

	<S extends Rol> S save(S entity);

	<S extends Rol> Iterable<S> saveAll(Iterable<S> entities);

	Optional<Rol> findById(Long id);

	boolean existsById(Long id);

	Iterable<Rol> findAll();

	Iterable<Rol> findAllById(Iterable<Long> ids);

	long count();

	void deleteById(Long id);

	void delete(Rol entity);

	void deleteAllById(Iterable<? extends Long> ids);

	void deleteAll(Iterable<? extends Rol> entities);

	void deleteAll();
	
	List<Rol> findByTipo(String tipo);

}