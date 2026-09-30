package com.financeiro.api.controller;

import com.financeiro.api.dto.TransacaoDTO;
import com.financeiro.api.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<TransacaoDTO> criar(@Valid @RequestBody TransacaoDTO dto) {
        TransacaoDTO salva = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }
}