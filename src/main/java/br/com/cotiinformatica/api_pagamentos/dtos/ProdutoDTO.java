package br.com.cotiinformatica.api_pagamentos.dtos;

import java.io.Serializable;

public record ProdutoDTO(
        String id,
        String nome,
        Double preco
) implements Serializable {
}