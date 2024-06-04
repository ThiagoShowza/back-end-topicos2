package org.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
@Getter
@Setter
@Entity
public class ItemPedido extends DefaultEntity {

    @NotBlank(message = "Informe a quantidade de itens")
    @Positive(message = "A quantidade inválida")
    private Integer quantidade;

    @NotNull
    @NotBlank(message = "Informe o tipo de pedido")
    private TipoPedido tipoPedido;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_joia", nullable = false)
    private Joia joia;
}
