package com.daw.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.model.Comentario;
import com.daw.model.Entrada;
import com.daw.service.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
//----------------------------------------------------GETMAPPING-----------------------------------------------

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> obtenerComentarios(){
		List<Comentario> result = (List<Comentario>) comentarioService.findAll();
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}
	
//----------------------------------------------------POSTMAPPING-----------------------------------------------
	
//	@PostMapping(value = "{entradaId}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
//			MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<?> crearComentarioEntrada(@PathVariable("entradaId") Long entradaId, @RequestBody Comentario nuevoComentario, String nombre){
//		Comentario comentario = comentarioService.crearComentario(nuevoComentario, entradaId, nombre);
//		return ResponseEntity.status(HttpStatus.CREATED).body(comentario);
//	}
	
	@PostMapping (produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> crearComentarioEntrada(@RequestBody Comentario nuevoComentario){
		Comentario comentario = comentarioService.crearComentario(nuevoComentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(comentario);
	}
		
//-----------------------------------------------------PUTMAPPING-------------------------------------------------

//----------------------------------------------------DELETEMAPPING-----------------------------------------------

}
