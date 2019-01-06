package com.sistemalerlivros.api.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sistemalerlivros.api.entity.Genero;

public class LivroDTO {

	@NotEmpty
	private String titulo;
	@NotEmpty
	private String autor;
	@NotNull
	private LocalDate dataLancamento;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Genero genero;
	@NotEmpty
	private String descricao;
	@NotNull
	private int notaMedia;

	public LivroDTO(String titulo, String autor, LocalDate dataLancamento, Genero genero, String descricao,
			int notaMedia) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.dataLancamento = dataLancamento;
		this.genero = genero;
		this.descricao = descricao;
		this.notaMedia = notaMedia;
	}

	public LivroDTO() {

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
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
		return "LivroDTO [titulo=" + titulo + ", autor=" + autor + ", dataLancamento=" + dataLancamento + ", genero="
				+ genero + ", descricao=" + descricao + ", notaMedia=" + notaMedia + "]";
	}

}
