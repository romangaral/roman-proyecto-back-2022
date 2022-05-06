package com.daw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.model.Rol;
import com.daw.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;

	public RolRepository getRolRepository() {
		return rolRepository;
	}
	
	public void setRolRepository(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}

	@Override
	public <S extends Rol> S save(S entity) {
		return rolRepository.save(entity);
	}

	@Override
	public <S extends Rol> Iterable<S> saveAll(Iterable<S> entities) {
		return rolRepository.saveAll(entities);
	}

	@Override
	public Optional<Rol> findById(Long id) {
		return rolRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return rolRepository.existsById(id);
	}

	@Override
	public Iterable<Rol> findAll() {
		return rolRepository.findAll();
	}

	@Override
	public Iterable<Rol> findAllById(Iterable<Long> ids) {
		return rolRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return rolRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		rolRepository.deleteById(id);
	}

	@Override
	public void delete(Rol entity) {
		rolRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		rolRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Rol> entities) {
		rolRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rolRepository.deleteAll();
	}

	@Override
	public List<Rol> findByTipo(String tipo) {
		// TODO Auto-generated method stub
		return rolRepository.findByTipo(tipo);
	}
	
	
	
}
