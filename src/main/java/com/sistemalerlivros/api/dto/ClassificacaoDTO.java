package com.sistemalerlivros.api.dto;

import com.sistemalerlivros.api.entity.Livro;
import com.sistemalerlivros.api.entity.StatusLivro;
import com.sistemalerlivros.api.entity.Usuario;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClassificacaoDTO {

    @NotNull
    private StatusLivro statusLivro;
    @NotNull
    @Valid
    private Livro livro;
    @NotNull
    @Valid
    private Usuario usuario;

}
