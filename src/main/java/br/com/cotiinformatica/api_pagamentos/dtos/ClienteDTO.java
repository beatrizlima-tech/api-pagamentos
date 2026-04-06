package br.com.cotiinformatica.api_pagamentos.dtos;

import java.io.Serializable;

public record ClienteDTO(
        String id,
        String nome,
        String email
) implements Serializable {
}