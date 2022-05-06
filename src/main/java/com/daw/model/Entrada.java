package com.daw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "entradas")
public class Entrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "titulo", nullable = false)
	private String titulo;
	@Column(name = "texto", nullable = false, columnDefinition = "text", length = 1500)
	private String texto;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "entrada", cascade = CascadeType.PERSIST)
	private List<Comentario> comentarioUsuario;

	public Entrada() {
		super();
		comentarioUsuario = new ArrayList<Comentario>();
	}

	public Entrada(Long id, String titulo, String texto, Usuario usuario, List<Comentario> comentarioUsuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		this.comentarioUsuario = comentarioUsuario;
	}

	public Entrada(String titulo, String texto, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		comentarioUsuario = new ArrayList<Comentario>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentario> getComentarioUsuario() {
		return comentarioUsuario;
	}

	public void setComentarioUsuario(List<Comentario> comentarioUsuario) {
		this.comentarioUsuario = comentarioUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentarioUsuario == null) ? 0 : comentarioUsuario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Entrada other = (Entrada) obj;
		if (comentarioUsuario == null) {
			if (other.comentarioUsuario != null)
				return false;
		} else if (!comentarioUsuario.equals(other.comentarioUsuario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
