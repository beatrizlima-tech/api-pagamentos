package br.com.cotiinformatica.api_pagamentos.controllers;

import br.com.cotiinformatica.api_pagamentos.dtos.PedidoDTO;
import br.com.cotiinformatica.api_pagamentos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentosController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("criar")
    public ResponseEntity<?> criar(@RequestBody PedidoDTO dto) {

        try {
            pedidoService.salvarPagamento(dto);
            return ResponseEntity.status(201).body("Pagamento capturado com sucesso!");
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
