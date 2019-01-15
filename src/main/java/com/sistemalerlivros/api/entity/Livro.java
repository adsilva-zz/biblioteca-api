package com.sistemalerlivros.api.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Livro implements Comparable<Livro> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLivro;
	@Column(length = 150)
	private String titulo;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "LIVRO_AUTOR", joinColumns = {
			@JoinColumn(name = "idLivro", referencedColumnName = "idLivro") }, inverseJoinColumns = {
					@JoinColumn(name = "idAutor", referencedColumnName = "idAutor") })
	// @JsonIgnore
	// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
	// property = "idAutor")
	@JsonManagedReference
	private List<Autor> autor;
	private LocalDate dataLancamento;
	private LocalDate dataCadastro;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private String descricao;
	private int notaMedia;

	public Livro(Long idLivro, String titulo, List<Autor> autor, LocalDate dataLancamento, LocalDate dataCadastro,
			Genero genero, String descricao, int notaMedia) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.dataLancamento = dataLancamento;
		this.dataCadastro = dataCadastro;
		this.genero = genero;
		this.descricao = descricao;
		this.notaMedia = notaMedia;
	}

	public Livro() {

	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Autor> getAutor() {
		return autor;
	}

	public void setListaAutor(List<Autor> autor) {
		this.autor = autor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(int notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", autor=" + autor + ", dataLancamento="
				+ dataLancamento + ", dataCadastro=" + dataCadastro + ", genero=" + genero + ", descricao=" + descricao
				+ ", notaMedia=" + notaMedia + "]";
	}

	@Override
	public int compareTo(Livro livro) {
		return this.getDataLancamento().compareTo(livro.getDataLancamento());
	}

}
