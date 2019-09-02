package com.sistemalerlivros.api.servico;

import com.sistemalerlivros.api.ConfiguracaoTest;
import com.sistemalerlivros.api.dto.AutorDTO;
import com.sistemalerlivros.api.entity.Autor;
import com.sistemalerlivros.api.exception.DataNascimentoInvalidaException;
import com.sistemalerlivros.api.template.AutorTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AutorServicoTest extends ConfiguracaoTest {

    @Autowired
    private AutorServico autorServico;

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

    // verificar se o livro está setado no autor
}
