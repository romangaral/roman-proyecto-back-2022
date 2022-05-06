package com.daw.service;

import java.util.Optional;

import com.daw.model.Entrada;

public interface EntradaService {
	
	public <S extends Entrada> S save(S entity);

	public <S extends Entrada> Iterable<S> saveAll(Iterable<S> entities);

	public Optional<Entrada> findById(Long id);

	public boolean existsById(Long id);

	public Iterable<Entrada> findAll();

	public Iterable<Entrada> findAllById(Iterable<Long> ids);

	public long count();

	public void deleteById(Long id);

	public void delete(Entrada entity);

	public void deleteAllById(Iterable<? extends Long> ids);

	public void deleteAll(Iterable<? extends Entrada> entities);

	public void deleteAll();
	
	public Entrada crearEntrada(Entrada nuevaEntrada);

}
