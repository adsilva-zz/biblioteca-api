package com.sistemalerlivros.api.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String nome, String user, String senha, String email, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.user = user;
		this.senha = senha;
		this.email = email;
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", user=" + user + ", senha=" + senha + ", email="
				+ email + ", perfil=" + perfil + "]";
	}
}
