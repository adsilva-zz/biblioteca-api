package com.sistemalerlivros.api.converts;

import org.springframework.core.convert.converter.Converter;

import com.sistemalerlivros.api.dto.LivroDTO;
import com.sistemalerlivros.api.entity.Livro;

public class DtoToLivroConverter implements Converter<LivroDTO, Livro> {

	@Override
	public Livro convert(LivroDTO livroDTO) {
		Livro livro = new Livro();
		livro.setAutor(livroDTO.getAutor());
		livro.setDataLancamento(livroDTO.getDataLancamento());
		livro.setDescricao(livroDTO.getDescricao());
		livro.setGenero(livroDTO.getGenero());
		livro.setNotaMedia(livroDTO.getNotaMedia());
		livro.setTitulo(livroDTO.getTitulo());
		return livro;
	}

}
