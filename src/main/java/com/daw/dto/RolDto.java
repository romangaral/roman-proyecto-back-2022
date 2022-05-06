package com.daw.dto;

public class RolDto {
	
	private Long id;
	private String tipo;
	
	
	public RolDto() {
		super();
	}


	public RolDto(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
