package org.acme.dto.Pedido;

import jakarta.validation.constraints.NotNull;
import org.acme.dto.ItemPedido.ItemPedidoDTO;
import org.acme.dto.Pessoa.PessoaDTO;

import java.util.List;

public record PedidoDTO(
        @NotNull(message = "A pessoa associada ao pedido não pode ser nula") PessoaDTO pessoa,
        List<ItemPedidoDTO> itens
) {}