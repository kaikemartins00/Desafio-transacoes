package com.kaikemartins.transacao_api.business.services;

import com.kaikemartins.transacao_api.controller.dtos.TransacaoRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDto> list = new ArrayList<>();

    public List<TransacaoRequestDto> transacoesEmIntervalo(Integer tempo) {
        log.info("Buscando transacoes em intervalo de " + tempo);
        return list.stream()
                .filter(transacoes -> transacoes.dataHora()
                        .isAfter(OffsetDateTime.now().minusSeconds(tempo)))
                .toList();

    }

    public TransacaoRequestDto criarTransacao(TransacaoRequestDto dto) {
        log.info("Criando transacao");
        list.add(dto);

        log.info("Transacao criada com sucesso");
        return dto;
    }

    public void deletarTransacao() {
        log.info("Iniciando processo de deletar transacoes");
        list.clear();
        log.info("Transacoes deletadas com sucesso");
    }
}


