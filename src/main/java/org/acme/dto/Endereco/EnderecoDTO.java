package org.acme.dto.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record EnderecoDTO(
        @Positive(message = "Id invalido")
        Long idCidade,
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 'XXXXX-XXX'.")
        String cep,
        @Positive(message = "O número deve ser positivo")
        Integer numero,
        @NotBlank(message = "Informe o bairro") String bairro,
        @NotBlank(message = "Informe o logradouro") String logradouro,
        String complemento
) {}