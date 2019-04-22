package com.sistemalerlivros.api.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sistemalerlivros.api.entity.Genero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LivroDTO {

	@NotEmpty
	private String titulo;
	// @NotEmpty
	private List<Long> autor;
	@NotNull
	private LocalDate dataLancamento;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Genero genero;
	@NotEmpty
	private String descricao;
	@NotNull
	private int notaMedia;
}
