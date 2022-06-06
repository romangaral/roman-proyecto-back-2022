package com.daw.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.daw.dto.ConverterDto;
import com.daw.dto.CrearUsuarioDto;
import com.daw.dto.UsuarioDto;
import com.daw.model.Usuario;
import com.daw.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//----------------------------------------------------GETMAPPING-----------------------------------------------
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> obtenerUsuarios(){
		List<Usuario> result = (List<Usuario>) usuarioService.findAll();
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}
	
	@GetMapping("/{id}")
	public Usuario obtenerUsuariosId(@PathVariable Long id){
		return usuarioService.findById(id).orElse(null);
	}

	@GetMapping(value = "/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UsuarioDto getUsuarioProfile(Principal p) { 
		String logUsuario = p.getName();
		Usuario usuario = usuarioService.findByNombre(logUsuario)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if (usuario.getUsername().equals(logUsuario)) {
			return ConverterDto.getToDtoInstance().map(usuario, UsuarioDto.class);
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	
//----------------------------------------------------POSTMAPPING-----------------------------------------------
	
	@PostMapping (produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> crearNuevoUsuario(@RequestBody CrearUsuarioDto nuevoUsuario){
		Usuario usuario = usuarioService.crearUsuario(nuevoUsuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(ConverterDto.getToDtoInstance().map(usuario, UsuarioDto.class));
	}
	
//	@PostMapping (produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
//	public Usuario crearNuevoUsuario(@RequestBody Usuario nuevoUsuario){
//		Usuario usuario = usuarioService.creaUsuario(nuevoUsuario);
//		return usuario;
//	}


//-----------------------------------------------------PUTMAPPING-------------------------------------------------

	@PutMapping(value = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> actualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioDto actualizarUsuario, BindingResult br){
		if (!br.hasErrors()) {
			return usuarioService.findById(id).map(usuario -> {
				usuario.setNombre(actualizarUsuario.getNombre());
				usuarioService.save(usuario);
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(ConverterDto.getToDtoInstance().map(usuario, UsuarioDto.class));
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getAllErrors());
		}
	}
	
//----------------------------------------------------DELETEMAPPING-----------------------------------------------
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Long id){
		Usuario usuario = usuarioService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		usuarioService.delete(usuario);
		return ResponseEntity.noContent().build();
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> borrarUsuario(@PathVariable Long id) {		
//		usuarioService.deleteById(id);
//		return ResponseEntity.noContent().build();
//	}
}
	