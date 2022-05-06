package com.daw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.daw.model.Entrada;
import com.daw.model.Usuario;
import com.daw.service.EntradaService;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

	@Autowired
	private EntradaService entradaService;
	
//----------------------------------------------------GETMAPPING-----------------------------------------------

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> obtenerEntradas(){
		List<Entrada> result = (List<Entrada>) entradaService.findAll();
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerEntradaPorId(@PathVariable Long id){
		Entrada result = entradaService.findById(id).orElse(null);
		if(result == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(result);
	}
	
//	@GetMapping
//	public List<Entrada> obtenerEntradas(){
//		return (List<Entrada>) entradaService.findAll();
//	}
//----------------------------------------------------POSTMAPPING-----------------------------------------------
	
	@PostMapping (produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> crearNuevaEntrada(@RequestBody Entrada nuevaEntrada){
		Entrada entrada = entradaService.crearEntrada(nuevaEntrada);
		return ResponseEntity.status(HttpStatus.CREATED).body(entrada);
	}
//-----------------------------------------------------PUTMAPPING-------------------------------------------------

//----------------------------------------------------DELETEMAPPING-----------------------------------------------

	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> eliminarEntrada(@PathVariable("id") Long id){
		Entrada entrada = entradaService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		entradaService.delete(entrada);
		return ResponseEntity.noContent().build();
	}
}
