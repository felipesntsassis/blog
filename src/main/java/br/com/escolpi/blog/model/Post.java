package br.com.escolpi.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "posts")
@SequenceGenerator(name = "posts_seq", initialValue = 1, allocationSize = 1)
public class Post implements Serializable {

	private static final long serialVersionUID = 4817082628066854890L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_seq")
	private Long id;

	@Column(nullable = false)
	@NotBlank(message = "Autor é obrigatório.")
	private String autor;

	@Column(nullable = false)
	@NotBlank(message = "Título é obrigatório.")
	private String titulo;

	@Column(nullable = false)
	@NotBlank(message = "Texto é obrigatório.")
	private String texto;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data é obrigatório.")
	@Temporal(TemporalType.DATE)
	private Date data;

	@OneToMany(mappedBy = "post")
	Set<Comentario> comentarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
