package com.sistemalerlivros.api.converts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sistemalerlivros.api.dto.LivroDTO;
import com.sistemalerlivros.api.entity.Livro;
import com.sistemalerlivros.api.entity.Livro.LivroBuilder;
import com.sistemalerlivros.api.servico.AutorServico;

@Component
public class DtoToLivroConverter implements Converter<LivroDTO, Livro> {

	@Autowired
	private AutorServico autorServico;

	@Override
	public Livro convert(LivroDTO livroDTO) {
		LivroBuilder livroBuilder = Livro.builder().autor(autorServico.listarAutor(livroDTO.getAutor()))
				.dataLancamento(livroDTO.getDataLancamento()).descricao(livroDTO.getDescricao())
				.genero(livroDTO.getGenero()).notaMedia(livroDTO.getNotaMedia()).titulo(livroDTO.getTitulo());

		return livroBuilder.build();
	}

}
