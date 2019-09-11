package com.sistemalerlivros.api.template;

import com.sistemalerlivros.api.dto.LivroDTO;
import com.sistemalerlivros.api.entity.Genero;
import com.sistemalerlivros.api.entity.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class LivroTemplate {

    public static Livro getLivro() {
        return Livro.builder().autor(Arrays.asList(AutorTemplate.getAutor()))
                .dataCadastro(LocalDate.now()).dataLancamento(LocalDate.now())
                .descricao("Ficção").genero(Genero.CONTOS).titulo("Era uma vez").notaMedia(5).build();
    }

    public static LivroDTO getLivroDTO(){
        return LivroDTO.builder().autor(new ArrayList<>())
                .dataLancamento(LocalDate.now()).descricao("testes")
                .genero(Genero.TEORIA).notaMedia(5).titulo("JUnit").build();
    }
}
