package com.sistemalerlivros.api.servico;

import com.sistemalerlivros.api.ConfiguracaoTest;
import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.dto.LivroDTO;
import com.sistemalerlivros.api.entity.Autor;
import com.sistemalerlivros.api.entity.Livro;
import com.sistemalerlivros.api.exception.DataNascimentoInvalidaException;
import com.sistemalerlivros.api.repository.LivroRepository;
import com.sistemalerlivros.api.template.AutorTemplate;
import com.sistemalerlivros.api.template.LivroTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class AutorServicoTest extends ConfiguracaoTest {

    @Autowired
    private AutorServico autorServico;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroServico livroServico;

    @Test
    public void cadastrarAutorComSucesso() {
        Autor autorCadastrado = autorServico.cadastrarAutor(AutorTemplate.getAutorDto());

        assertThat(autorCadastrado).isNotNull();
        assertThat(autorCadastrado.getLivro()).isNotNull();
        assertThat(autorCadastrado.getIdAutor()).isNotNull();
        assertThat(autorCadastrado.getNome()).isEqualTo(AutorTemplate.getAutorDto().getNome());
        assertThat(autorCadastrado.getDataNascimento()).isEqualTo(AutorTemplate.getAutorDto().getDataNascimento());
    }

    @Test
    public void cadastrarAutorDataNascimentoInvalida() {
        AutorDTO autorDTO = AutorTemplate.getAutorDto();
        autorDTO.setDataNascimento(LocalDate.now().plusDays(2));
        assertThatExceptionOfType(DataNascimentoInvalidaException.class).isThrownBy(() -> autorServico.cadastrarAutor(autorDTO));
    }

    @Test
        public void verificarRelacionamentoLivroComAutor(){
        Autor autorCadastrado = autorServico.cadastrarAutor(AutorTemplate.getAutorDto());
        final LivroDTO livroDTO = LivroTemplate.getLivroDTO();
        livroDTO.getAutor().add(autorCadastrado.getIdAutor());
        assertThat(livroServico.cadastrarLivro(livroDTO).getAutor().get(0).getIdAutor()).isEqualTo(autorCadastrado.getIdAutor());

        autorServico.buscarAutor(1L);

        livroServico.buscarLivro(2l);


    }
}
