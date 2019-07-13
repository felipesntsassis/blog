package br.com.escolpi.blog.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "comentarios")
@SequenceGenerator(name = "comentarios_seq", initialValue = 1, allocationSize = 1)
public class Comentario implements Serializable {

	private static final long serialVersionUID = 2653772265709607834L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentarios_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(
		name = "post_id",
		referencedColumnName = "id", 
		foreignKey = @ForeignKey(name = "fk_comentarios_posts")
	)
	private Post post;

	@Column(nullable = false)
	@NotBlank(message = "Texto é obrigatório.")
	private String texto;

	@Column(name = "dt_hora", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data e Hora são obrigatórios.")
	@Temporal(TemporalType.DATE)
	private Date dataEHora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataEHora() {
		return dataEHora;
	}

	public void setDataEHora(Date dataEHora) {
		this.dataEHora = dataEHora;
	}

}
