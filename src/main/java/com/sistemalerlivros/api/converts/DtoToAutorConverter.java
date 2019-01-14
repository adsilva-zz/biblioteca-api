package com.sistemalerlivros.api.converts;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.ObjectUtils;

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
		if (!ObjectUtils.isEmpty(autorDTO.getLivrosAutor())) {
			autor.setLivro(livroServico.listarLivros(autorDTO.getLivrosAutor()));
		}
		autor.setLivro(new ArrayList<>());
		return autor;
	}

}
