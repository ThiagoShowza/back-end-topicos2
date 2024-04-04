package org.acme.dto.Cartao;

import jakarta.validation.constraints.NotBlank;

public record CartaoDTO(

    Long idPedido,
    @NotBlank(message = "O campo nome não pode ser nulo")
    String nome,
    @NotBlank(message = "O campo numero não pode ser nulo")
    String numero,
    @NotBlank(message = "O campo data não pode ser nulo")
    String dataValidade,
    @NotBlank(message = "O campo cvc não pode ser nulo")
    Integer cvc,
    @NotBlank(message = "O campo bandeira não pode ser nulo")
    Long idBandeira



) {
}
