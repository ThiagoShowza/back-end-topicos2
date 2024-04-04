package org.acme.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record PessoaDTO(
                @NotBlank String nome,
                @NotBlank @CPF String cpf,
                @Pattern(regexp = "^$|^[0-9]{10,15}$", message = "Número de telefone inválido")
                String telefone,
                @Past(message = "Data de nascimento inválida")
                LocalDate dataNascimento,
                List<EnderecoDTO> listaEndereco,
                String nomeImagem) {
}