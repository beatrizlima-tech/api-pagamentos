package br.com.cotiinformatica.api_pagamentos.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(
        String id,
        ClienteDTO cliente,
        LocalDateTime dataHora,
        Double valor,
        List<ItemPedidoDTO> itensPedido
) implements Serializable {
}
