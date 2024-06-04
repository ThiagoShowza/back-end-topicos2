package org.acme.service.Pedido;

import org.acme.dto.Pedido.PedidoDTO;
import org.acme.dto.Pedido.PedidoResponseDTO;

import java.util.List;

public interface PedidoService {
    PedidoResponseDTO insert(PedidoDTO dto);
    PedidoResponseDTO update(PedidoDTO dto, Long id);
    void delete(Long id);
    PedidoResponseDTO findById(Long id);
    List<PedidoResponseDTO> findAll();
}
