package com.sistemalerlivros.api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemalerlivros.api.entity.Genero;
import com.sistemalerlivros.api.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	public List<Livro> findByTituloContaining(String titulo, Sort sort);

	public List<Livro> findByGenero(Genero genero, Sort sort);
	
	public List<Livro> findByAutor(String autor, Sort sort);
}
