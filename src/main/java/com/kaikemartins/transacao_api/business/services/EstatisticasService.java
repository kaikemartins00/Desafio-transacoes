package com.kaikemartins.transacao_api.business.services;

import com.kaikemartins.transacao_api.controller.dtos.EstatisticasResponseDto;
import com.kaikemartins.transacao_api.controller.dtos.TransacaoRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

    public final TransacaoService transacaoService;

    public EstatisticasResponseDto calcularEstatisticasTrasacoes(Integer tempo) {

        log.info("Iniciando EstatisticasService.calcularEstatisticasTrasacoes()");
        List<TransacaoRequestDto> transacoes = transacaoService.transacoesEmIntervalo(tempo);

        if (transacoes.isEmpty()) {
            return new EstatisticasResponseDto(0L, 0.0, 0.0, 0.0, 0.0);
        }
        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream()
                .mapToDouble(TransacaoRequestDto::valor)
                .summaryStatistics();

        log.info("Estatisticas retornadas com sucesso");
        return new EstatisticasResponseDto(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(), estatisticasTransacoes.getAverage(), estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());
    }
}
