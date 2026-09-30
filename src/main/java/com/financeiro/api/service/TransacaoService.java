package com.financeiro.api.service;

import com.financeiro.api.dto.TransacaoDTO;
import com.financeiro.api.model.Transacao;
import com.financeiro.api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    public List<TransacaoDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public TransacaoDTO salvar(TransacaoDTO dto) {
        Transacao entity = converterParaEntidade(dto);
        Transacao salva = repository.save(entity);
        return converterParaDTO(salva);
    }

    private TransacaoDTO converterParaDTO(Transacao entity) {
        return new TransacaoDTO(
                entity.getId(),
                entity.getDescricao(),
                entity.getValor(),
                entity.getTipo(),
                entity.getCategoria(),
                entity.getDataHora()
        );
    }

    private Transacao converterParaEntidade(TransacaoDTO dto) {
        Transacao entity = new Transacao();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setValor(dto.getValor());
        entity.setTipo(dto.getTipo());
        entity.setCategoria(dto.getCategoria());
        entity.setDataHora(dto.getDataHora());
        return entity;
    }
}