package com.sistemalerlivros.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sistemalerlivros.api.converts.DtoToAutorConverter;
import com.sistemalerlivros.api.converts.DtoToLivroConverter;
import com.sistemalerlivros.api.converts.DtoToUsuarioConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new DtoToLivroConverter());
		registry.addConverter(new DtoToUsuarioConverter());
		registry.addConverter(new DtoToAutorConverter());
	}
}
