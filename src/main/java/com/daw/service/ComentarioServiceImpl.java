package com.daw.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.model.Comentario;
import com.daw.model.Entrada;
import com.daw.model.Usuario;
import com.daw.repository.ComentarioRepository;
import com.daw.repository.EntradaRepository;
import com.daw.repository.UsuarioRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public ComentarioRepository getComentarioRepository() {
		return comentarioRepository;
	}

	public void setComentarioRepository(ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}

	public <S extends Comentario> S save(S entity) {
		return comentarioRepository.save(entity);
	}

	public <S extends Comentario> Iterable<S> saveAll(Iterable<S> entities) {
		return comentarioRepository.saveAll(entities);
	}

	public Optional<Comentario> findById(Long id) {
		return comentarioRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return comentarioRepository.existsById(id);
	}

	public Iterable<Comentario> findAll() {
		return comentarioRepository.findAll();
	}

	public Iterable<Comentario> findAllById(Iterable<Long> ids) {
		return comentarioRepository.findAllById(ids);
	}

	public long count() {
		return comentarioRepository.count();
	}

	public void deleteById(Long id) {
		comentarioRepository.deleteById(id);
	}

	public void delete(Comentario entity) {
		comentarioRepository.delete(entity);
	}

	public void deleteAllById(Iterable<? extends Long> ids) {
		comentarioRepository.deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Comentario> entities) {
		comentarioRepository.deleteAll(entities);
	}

	public void deleteAll() {
		comentarioRepository.deleteAll();
	}
	
//	public Comentario crearComentarioEntrada(Comentario nuevoComentario, Long entradaId, String nombre) {
//		Entrada entrada = entradaRepository.findById(entradaId).orElse(null);		
//		Usuario usuario = usuarioRepository.findByNombre(nombre).orElse(null);
//		Comentario comentario = new Comentario();
//		comentario.setTexto(nuevoComentario.getTexto());
//		comentario.setEntrada(entrada);
//		comentario.setUsuario(usuario);
//		return comentarioRepository.save(comentario);
//	}
	
	public Comentario crearComentario(Comentario nuevoComentario) {
		Comentario comentario = new Comentario();
		comentario.setTexto(nuevoComentario.getTexto());
		return comentarioRepository.save(comentario);
	}
}
