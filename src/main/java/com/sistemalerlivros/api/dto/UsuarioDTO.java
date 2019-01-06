package com.sistemalerlivros.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sistemalerlivros.api.entity.Perfil;

public class UsuarioDTO {

	@NotEmpty
	private String nome;
	@NotEmpty
	private String user;
	@NotBlank
	private String senha;
	@NotEmpty
	@Email
	private String email;
	@NotNull
	private Perfil perfil;

	public UsuarioDTO() {

	}

	public UsuarioDTO(String nome, String user, String senha, String email, Perfil perfil) {
		super();
		this.nome = nome;
		this.user = user;
		this.senha = senha;
		this.email = email;
		this.perfil = perfil;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [nome=" + nome + ", user=" + user + ", senha=" + senha + ", email=" + email + ", perfil="
				+ perfil + "]";
	}

}
