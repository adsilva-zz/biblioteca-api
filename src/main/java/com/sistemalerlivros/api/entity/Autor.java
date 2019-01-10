package com.sistemalerlivros.api.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAutor;
	private String nome;
	private LocalDate dataNascimento;
	@ManyToMany(mappedBy = "autor", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Livro> livrosAutor;

	public Autor() {

	}

	public Autor(String nome, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.livrosAutor = new ArrayList<>();
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

	public int getIdAutor() {
		return idAutor;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
	}

}
