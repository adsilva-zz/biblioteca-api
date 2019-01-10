package com.sistemalerlivros.api.servico;

import java.util.List;

import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;

public interface AutorServico {

	public Autor cadastrarAutor(AutorDTO autor);

	public List<Autor> listarAutor();

	public Autor atualizarAutor(AutorDTO novoAutor, Long idAutor);

	public Autor buscarAutor(Long idAutor);

	public boolean deletarAutor(Long idAutor);

	public List<Autor> listarAutor(List<Long> listaIdAutor);
}
