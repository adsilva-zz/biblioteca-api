package com.sistemalerlivros.api.servico;

import java.util.List;

import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;

public interface AutorServico {

	public Autor cadastrarAutor(AutorDTO autor);

	public List<Autor> listarAautor();

	public Autor atualizarAutor(AutorDTO novoAutor, Long idAutor);

	public Autor buscarAutor(Long idAutor);

	public boolean deletarAutor(Long idAutor);
}
