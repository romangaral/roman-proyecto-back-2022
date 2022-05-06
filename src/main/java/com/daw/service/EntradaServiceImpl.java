package com.daw.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.model.Entrada;
import com.daw.model.Usuario;
import com.daw.repository.EntradaRepository;
import com.daw.repository.UsuarioRepository;

@Service
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public EntradaRepository getEntradaRepository() {
		return entradaRepository;
	}

	public void setEntradaRepository(EntradaRepository entradaRepository) {
		this.entradaRepository = entradaRepository;
	}

	public <S extends Entrada> S save(S entity) {
		return entradaRepository.save(entity);
	}

	public <S extends Entrada> Iterable<S> saveAll(Iterable<S> entities) {
		return entradaRepository.saveAll(entities);
	}

	public Optional<Entrada> findById(Long id) {
		return entradaRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return entradaRepository.existsById(id);
	}

	public Iterable<Entrada> findAll() {
		return entradaRepository.findAll();
	}

	public Iterable<Entrada> findAllById(Iterable<Long> ids) {
		return entradaRepository.findAllById(ids);
	}

	public long count() {
		return entradaRepository.count();
	}

	public void deleteById(Long id) {
		entradaRepository.deleteById(id);
	}

	public void delete(Entrada entity) {
		entradaRepository.delete(entity);
	}

	public void deleteAllById(Iterable<? extends Long> ids) {
		entradaRepository.deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Entrada> entities) {
		entradaRepository.deleteAll(entities);
	}

	public void deleteAll() {
		entradaRepository.deleteAll();
	}
	
	public Entrada crearEntrada(Entrada nuevaEntrada) {
		Entrada entrada = new Entrada();
		entrada.setTitulo(nuevaEntrada.getTitulo());
		entrada.setTexto(nuevaEntrada.getTexto());
		return entradaRepository.save(entrada);
	}
}
