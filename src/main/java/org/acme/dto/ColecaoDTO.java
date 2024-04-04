package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record ColecaoDTO(
        @NotBlank(message = "O nome da coleção não pode estar em branco")
        String nome,

        String descricao,

        Long pessoaId
){}
