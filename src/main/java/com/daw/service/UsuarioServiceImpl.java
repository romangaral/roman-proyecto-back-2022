package com.daw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daw.dto.ConverterDto;
import com.daw.dto.CrearUsuarioDto;
import com.daw.model.Rol;
import com.daw.model.Usuario;
import com.daw.model.UsuarioRol;
import com.daw.repository.RolRepository;
import com.daw.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public <S extends Usuario> S save(S entity) {
		return usuarioRepository.save(entity);
	}

	@Override
	public <S extends Usuario> Iterable<S> saveAll(Iterable<S> entities) {
		return usuarioRepository.saveAll(entities);
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return usuarioRepository.existsById(id);
	}

	@Override
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Iterable<Usuario> findAllById(Iterable<Long> ids) {
		return usuarioRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return usuarioRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public void delete(Usuario entity) {
		usuarioRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		usuarioRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Usuario> entities) {
		usuarioRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		usuarioRepository.deleteAll();
	}

//	@Override
//	public Usuario crearUsuario(Usuario nuevoUsuario) {
//		Usuario usuario = new Usuario();
//		usuario.setNombre(nuevoUsuario.getNombre());
//		usuario.setApellidos(nuevoUsuario.getApellidos());
//		usuario.setEmail(nuevoUsuario.getEmail());
//		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
//		
//		Rol rol = rolRepository.findByTipo("user").get(0);
//		usuario.getRoles().add(new UsuarioRol(usuario, rol));
//		return usuarioRepository.save(usuario);
//	}
	
	@Override
	public Usuario crearUsuario(CrearUsuarioDto usuarioDto) {
		Usuario usuario = ConverterDto.getToModelInstance().map(usuarioDto, Usuario.class);
		//usuario.setNombre(usuarioDto.getNombre());
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
		Rol rol = rolRepository.findByTipo("user").get(0);
		usuario.getRoles().add(new UsuarioRol(usuario, rol));
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombre(nombre)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return usuario;
	}

	

	
}
