package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        Long idCidade,
        @NotBlank @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
        String cep,
        @Positive(message = "O número deve ser positivo")
        Integer numero,
        @NotBlank(message = "Informe o bairro") String bairro,
        @NotBlank(message = "Informe o logradouro") String logradouro,
        String complemento
) {}