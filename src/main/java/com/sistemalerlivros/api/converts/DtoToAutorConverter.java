package com.sistemalerlivros.api.converts;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;
import com.sistemalerlivros.api.entity.Autor.AutorBuilder;
import com.sistemalerlivros.api.servico.LivroServico;

@Component
public class DtoToAutorConverter implements Converter<AutorDTO, Autor> {

	@Autowired
	private LivroServico livroServico;

	@Override
	public Autor convert(AutorDTO autorDTO) {
		AutorBuilder autorBuilder = Autor.builder().nome(autorDTO.getNome())
				.dataNascimento(autorDTO.getDataNascimento());

		if (!ObjectUtils.isEmpty(autorDTO.getLivros())) {
			autorBuilder.livro(livroServico.listarLivros(autorDTO.getLivros()));
		} else {
			autorBuilder.livro(new ArrayList<>());
		}
		return autorBuilder.build();
	}

}
