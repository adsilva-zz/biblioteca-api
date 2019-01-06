package com.sistemalerlivros.api.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.sistemalerlivros.api.entity.Usuario;

@Component
@SessionScope
public class Session {

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
