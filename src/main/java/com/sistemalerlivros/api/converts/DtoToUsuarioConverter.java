package com.sistemalerlivros.api.converts;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sistemalerlivros.api.dto.UsuarioDTO;
import com.sistemalerlivros.api.entity.Usuario;
import com.sistemalerlivros.api.entity.Usuario.UsuarioBuilder;

@Component
public class DtoToUsuarioConverter implements Converter<UsuarioDTO, Usuario> {

	@Override
	public Usuario convert(UsuarioDTO usuarioDTO) {
		UsuarioBuilder usuarioBuilder = Usuario.builder().email(usuarioDTO.getEmail()).nome(usuarioDTO.getNome())
				.perfil(usuarioDTO.getPerfil()).senha(usuarioDTO.getSenha()).user(usuarioDTO.getUser());

		return usuarioBuilder.build();
	}

}
