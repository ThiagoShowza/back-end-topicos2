package org.acme.dto.Pessoa;

import java.time.LocalDate;
import java.util.List;

import org.acme.dto.Endereco.EnderecoDTO;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PessoaDTO(
        @NotBlank String nome,
        @NotBlank @Size(min = 4, max = 25, message = "A senha deve ter entre de 4 a 25 caracteres") String senha,
        @NotBlank @CPF String cpf,
        @Pattern(regexp = "^$|^[0-9]{10,15}$", message = "Número de telefone inválido") String telefone,
        @NotBlank @Email String email,
        @Past(message = "Data de nascimento inválida") LocalDate dataNascimento,
        List<EnderecoDTO> ListaEndereco,
        String nomeImagem) {
}