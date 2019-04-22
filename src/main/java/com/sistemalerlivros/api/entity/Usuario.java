package com.sistemalerlivros.api.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	private String nome;
	private String user;
	private String senha;
	private String email;
	@Enumerated
	private Perfil perfil;

}
