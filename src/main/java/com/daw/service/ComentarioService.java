package com.daw.service;

import java.util.Optional;

import com.daw.model.Comentario;
import com.daw.model.Entrada;
import com.daw.model.Usuario;

public interface ComentarioService {

	public <S extends Comentario> S save(S entity);

	public <S extends Comentario> Iterable<S> saveAll(Iterable<S> entities);

	public Optional<Comentario> findById(Long id);

	public boolean existsById(Long id);

	public Iterable<Comentario> findAll();

	public Iterable<Comentario> findAllById(Iterable<Long> ids);

	public long count();

	public void deleteById(Long id);

	public void delete(Comentario entity);

	public void deleteAllById(Iterable<? extends Long> ids);

	public void deleteAll(Iterable<? extends Comentario> entities);

	public void deleteAll();
	
	//public Comentario crearComentario(Comentario nuevoComentario, Long entradaId, String nombre);
	public Comentario crearComentario(Comentario nuevoComentario);
}
