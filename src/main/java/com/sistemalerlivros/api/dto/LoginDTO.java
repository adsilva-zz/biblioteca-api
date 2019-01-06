package com.sistemalerlivros.api.dto;

import javax.validation.constraints.NotBlank;

public class LoginDTO {

	@NotBlank
	private String user;
	@NotBlank
	private String senha;

	public LoginDTO() {

	}

	public LoginDTO(String user, String senha) {
		super();
		this.user = user;
		this.senha = senha;
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

}
