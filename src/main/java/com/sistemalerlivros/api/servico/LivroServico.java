package com.sistemalerlivros.api.servico;

import java.util.List;

import com.sistemalerlivros.api.dto.LivroDTO;
import com.sistemalerlivros.api.entity.Livro;

public interface LivroServico {

	public Livro cadastrarLivro(LivroDTO livro);

	public List<Livro> listarLivros(String titulo, String genero, String autor);

	public Livro buscarLivro(Long idLivro);

	public boolean deletarLivro(Long idLivro);

	public Livro atualizarLivro(LivroDTO livro, Long id);

	public List<Livro> listarLivros(List<Long> listaIdLivros);
}
