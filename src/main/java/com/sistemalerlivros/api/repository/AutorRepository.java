package com.sistemalerlivros.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemalerlivros.api.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

	
}
