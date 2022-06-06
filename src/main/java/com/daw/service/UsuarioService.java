package com.daw.service;

import java.util.List;
import java.util.Optional;

import com.daw.dto.CrearUsuarioDto;
import com.daw.model.Usuario;
import com.daw.repository.UsuarioRepository;

public interface UsuarioService {

	<S extends Usuario> S save(S entity);

	<S extends Usuario> Iterable<S> saveAll(Iterable<S> entities);

	Optional<Usuario> findById(Long id);

	boolean existsById(Long id);

	Iterable<Usuario> findAll();

	Iterable<Usuario> findAllById(Iterable<Long> ids);

	long count();

	void deleteById(Long id);

	void delete(Usuario entity);

	void deleteAllById(Iterable<? extends Long> ids);

	void deleteAll(Iterable<? extends Usuario> entities);

	void deleteAll();
	
	Usuario crearUsuario(CrearUsuarioDto usuarioDto);
	//Usuario crearUsuario(Usuario nuevoUsuario);
	
	Optional<Usuario> findByNombre(String nombre);

}