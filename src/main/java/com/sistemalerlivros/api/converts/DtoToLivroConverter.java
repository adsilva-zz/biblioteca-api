package com.sistemalerlivros.api.converts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sistemalerlivros.api.dto.LivroDTO;
import com.sistemalerlivros.api.entity.Livro;
import com.sistemalerlivros.api.servico.AutorServico;

@Component
public class DtoToLivroConverter implements Converter<LivroDTO, Livro> {

	@Autowired
	private AutorServico autorServico;

	@Override
	public Livro convert(LivroDTO livroDTO) {
		Livro livro = new Livro();
		livro.setListaAutor(autorServico.listarAutor(livroDTO.getAutor()));
		livro.setDataLancamento(livroDTO.getDataLancamento());
		livro.setDescricao(livroDTO.getDescricao());
		livro.setGenero(livroDTO.getGenero());
		livro.setNotaMedia(livroDTO.getNotaMedia());
		livro.setTitulo(livroDTO.getTitulo());
		return livro;
	}

}
