package com.sistemalerlivros.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;
import com.sistemalerlivros.api.servico.AutorServico;

@RestController
@RequestMapping("api/v1/lerLivros/autor")
public class AutorController {

	@Autowired
	private AutorServico autorServico;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Autor> cadastrarAutor(@Valid @RequestBody AutorDTO autor) {
		return new ResponseEntity<Autor>(autorServico.cadastrarAutor(autor), HttpStatus.CREATED);
	}
}
