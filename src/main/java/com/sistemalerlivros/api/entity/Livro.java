package com.sistemalerlivros.api.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sistemalerlivros.api.entity.Autor.AutorBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Livro implements Comparable<Livro> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLivro;
	@Column(length = 150)
	private String titulo;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "LIVRO_AUTOR", joinColumns = {
			@JoinColumn(name = "idLivro", referencedColumnName = "idLivro") }, inverseJoinColumns = {
					@JoinColumn(name = "idAutor", referencedColumnName = "idAutor") })
	@JsonManagedReference
	private List<Autor> autor;
	private LocalDate dataLancamento;
	private LocalDate dataCadastro;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private String descricao;
	private int notaMedia;
	private StatusLivro status; 

	@Override
	public int compareTo(Livro livro) {
		return this.getDataLancamento().compareTo(livro.getDataLancamento());
	}

}
