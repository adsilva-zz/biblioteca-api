package com.sistemalerlivros.api.converts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;
import com.sistemalerlivros.api.servico.LivroServico;

public class DtoToAutorConverter implements Converter<AutorDTO, Autor> {

	@Autowired
	private LivroServico livroServico;

	@Override
	public Autor convert(AutorDTO autorDTO) {
		Autor autor = new Autor();
		autor.setNome(autorDTO.getNome());
		autor.setDataNascimento(autorDTO.getDataNascimento());
		autor.setLivro(livroServico.listarLivros(autorDTO.getLivrosAutor()));
		return autor;
	}

}
