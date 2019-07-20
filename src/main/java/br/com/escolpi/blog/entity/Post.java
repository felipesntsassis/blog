package br.com.escolpi.blog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "posts")
@SequenceGenerator(name = "posts_seq", initialValue = 1, allocationSize = 1)
public class Post implements Serializable {

	private static final long serialVersionUID = 5468383055126247835L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postsSeq")
	@Column(nullable = false)
	private Long id;

	@Column(length = 100)
	@NotBlank(message = "Autor é obrigatório.")
	private String autor;

	@Column(length = 150)
	@NotBlank(message = "Título é obrigatório.")
	private String titulo;

	@Column(length = 3000)
	@NotBlank(message = "Texto é obrigatório.")
	private String texto;

	@Column(name = "dt_publicacao", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Data de publicação é obrigatório.")
	private Date dataPublicacao;

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

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
