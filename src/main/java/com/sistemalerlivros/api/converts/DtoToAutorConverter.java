package com.sistemalerlivros.api.converts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;
import com.sistemalerlivros.api.entity.Livro;
import com.sistemalerlivros.api.exception.LivroNaoEncontradoException;
import com.sistemalerlivros.api.servico.LivroServico;

public class DtoToAutorConverter implements Converter<AutorDTO, Autor> {

	@Autowired
	private LivroServico livroServico;

	@Override
	public Autor convert(AutorDTO autorDTO) {
		Autor autor = new Autor();
		autor.setNome(autorDTO.getNome());
		autor.setDataNascimento(autorDTO.getDataNascimento());

		List<Livro> listaLivro = new ArrayList<>();
		Livro l;
		for (Long id : autorDTO.getLivrosAutor()) {
			l = livroServico.buscarLivro(id);
			if (!Objects.isNull(l)) {
				listaLivro.add(l);
			} else {
				throw new LivroNaoEncontradoException(id); 
			}
		}
		autor.setLivro(listaLivro);
		return autor;
	}

}
