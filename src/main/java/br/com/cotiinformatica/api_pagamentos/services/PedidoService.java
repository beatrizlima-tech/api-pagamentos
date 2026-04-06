package br.com.cotiinformatica.api_pagamentos.services;

import br.com.cotiinformatica.api_pagamentos.dtos.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void salvarPagamento(PedidoDTO dto) throws Exception {

        // Salvar os dados no banco
        redisTemplate.opsForValue().set("pedido: " + dto.id(), dto);
    }
}
