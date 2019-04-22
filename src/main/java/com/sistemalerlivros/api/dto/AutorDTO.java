package com.sistemalerlivros.api.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class AutorDTO {

	@NotEmpty
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	private List<Long> livros;

}
