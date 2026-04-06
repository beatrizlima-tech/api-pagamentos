package br.com.cotiinformatica.api_pagamentos.dtos;

import java.io.Serializable;

public record ItemPedidoDTO(
        String id,
        ProdutoDTO produto,
        Integer quantidade
) implements Serializable {
}
