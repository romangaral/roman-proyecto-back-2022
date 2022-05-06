package com.daw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "tipo", length = 20, nullable = false)
	private String tipo;

	@JsonBackReference
	@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<UsuarioRol> usuarios;

	public Rol() {
		super();
		usuarios = new ArrayList<UsuarioRol>();
	}

	public Rol(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
		usuarios = new ArrayList<UsuarioRol>();
	}

	public Rol(Long id, String tipo, List<UsuarioRol> usuarios) {
		super();
		this.id = id;
		this.tipo = tipo;
		usuarios = new ArrayList<UsuarioRol>();
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

	public List<UsuarioRol> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioRol> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
