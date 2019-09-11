package com.sistemalerlivros.api.servico.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.sistemalerlivros.api.dto.LivroDTO;
import com.sistemalerlivros.api.entity.Genero;
import com.sistemalerlivros.api.entity.Livro;
import com.sistemalerlivros.api.exception.GeneroException;
import com.sistemalerlivros.api.exception.LivroNaoEncontradoException;
import com.sistemalerlivros.api.repository.LivroRepository;
import com.sistemalerlivros.api.servico.AutorServico;
import com.sistemalerlivros.api.servico.LivroServico;

@Service
public class LivroServicoImpl implements LivroServico {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorServico autorServico;

	@Autowired
	private ConversionService conversionService;

	@Override
	@Transactional
	public Livro cadastrarLivro(LivroDTO livroDTO) {
		Livro livro = conversionService.convert(livroDTO, Livro.class);
		livro.setDataCadastro(LocalDate.now());
		return livroRepository.save(livro);
	}

	@Override
	public List<Livro> listarLivros(String titulo, String genero, String autor) {
		Sort sort = Sort.by(Direction.DESC, "dataLancamento");
		if (!StringUtils.isEmpty(titulo)) {
			return livroRepository.findByTituloContaining(titulo, sort);
		} else if (!StringUtils.isEmpty(genero)) {
			Genero generoParsed = Genero.parse(genero);
			if (Objects.isNull(generoParsed)) {
				throw new GeneroException();
			}
			return livroRepository.findByGenero(generoParsed, sort);
		} else if (!StringUtils.isEmpty(autor)) {
			livroRepository.findByAutor(autor, sort);
		}
		return livroRepository.findAll(sort);
	}

	@Override
	public Livro buscarLivro(Long idLivro) {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		if (ObjectUtils.isEmpty(livro)) {
			return null;
		}
		return livro.get();
	}

	@Override
	public boolean deletarLivro(Long idLivro) {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		if (ObjectUtils.isEmpty(livro)) {
			return false;
		}
		livroRepository.deleteById(idLivro);
		return true;
	}

	@Override
	public Livro atualizarLivro(LivroDTO novoLivro, Long id) {
		Livro livro = this.buscarLivro(id);
		if (ObjectUtils.isEmpty(livro)) {
			return null;
		}

		livro.setAutor(autorServico.listarAutor(novoLivro.getAutor()));
		livro.setDataLancamento(novoLivro.getDataLancamento());
		livro.setDescricao(novoLivro.getDescricao());
		livro.setGenero(novoLivro.getGenero());
		livro.setNotaMedia(novoLivro.getNotaMedia());
		livro.setTitulo(novoLivro.getTitulo());

		return livroRepository.save(livro);
	}

	@Override
	public List<Livro> listarLivros(List<Long> listaIdLivros) {
		List<Livro> listaLivro = new ArrayList<>();
		Livro l;
		for (Long id : listaIdLivros) {
			l = buscarLivro(id);
			if (!Objects.isNull(l)) {
				listaLivro.add(l);
			} else {
				throw new LivroNaoEncontradoException(id);
			}
		}
		return listaLivro;
	}

}
