package com.sistemalerlivros.api.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorDTO {

	@NotEmpty
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	@NotEmpty
	private List<Long> livros;

	public AutorDTO(@NotEmpty String nome, @NotNull LocalDate dataNascimento, @NotEmpty List<Long> livros) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.livros = livros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Long> getLivrosAutor() {
		return livros;
	}

	public void setLivrosAutor(List<Long> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "AutorDTO [nome=" + nome + ", dataNascimento=" + dataNascimento + ", livros=" + livros + "]";
	}
}
