package com.sistemalerlivros.api.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;
import com.sistemalerlivros.api.repository.AutorRepository;
import com.sistemalerlivros.api.servico.AutorServico;

@Service
public class AutorServicoImpl implements AutorServico {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private ConversionService conversionService;

	@Override
	public Autor cadastrarAutor(AutorDTO autorDTO) {
		Autor autor = conversionService.convert(autorDTO, Autor.class);
		return autorRepository.save(autor);
	}

	@Override
	public List<Autor> listarAautor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor atualizarAutor(AutorDTO novoAutor, Long idAutor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor buscarAutor(Long idAutor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletarAutor(Long idAutor) {
		// TODO Auto-generated method stub
		return false;
	}

}
