package com.sistemalerlivros.api.converts;

import org.springframework.core.convert.converter.Converter;

import com.sistemalerlivros.api.dto.UsuarioDTO;
import com.sistemalerlivros.api.entity.Usuario;

public class DtoToUsuarioConverter implements Converter<UsuarioDTO, Usuario> {

	@Override
	public Usuario convert(UsuarioDTO usuarioDTO) {
		Usuario user = new Usuario();

		user.setEmail(usuarioDTO.getEmail());
		user.setNome(usuarioDTO.getNome());
		user.setPerfil(usuarioDTO.getPerfil());
		user.setSenha(usuarioDTO.getSenha());
		user.setUser(usuarioDTO.getUser());
		return user;
	}

}
