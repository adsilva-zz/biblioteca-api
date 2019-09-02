package com.sistemalerlivros.api.template;

import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;

import java.time.LocalDate;

public abstract class AutorTemplate {

    public static Autor getAutor() {
        return Autor.builder().nome("José Neves").dataNascimento(LocalDate.of(1970, 10, 23)).build();
    }

    public static AutorDTO getAutorDto() {
        return AutorDTO.builder().nome("José Neves").dataNascimento(LocalDate.of(1970, 10, 23)).build();
    }
}
