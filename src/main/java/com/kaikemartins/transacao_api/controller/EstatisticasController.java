package com.kaikemartins.transacao_api.controller;

import com.kaikemartins.transacao_api.business.services.EstatisticasService;
import com.kaikemartins.transacao_api.controller.dtos.EstatisticasResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticasService estatisticasService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Endpoint para buscar por estatisticas de trasacoes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na busca por estatisticas de transacoes"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")})
    public EstatisticasResponseDto getEstatisticas(@RequestParam(value = "tempoBusca", required = false, defaultValue = "60") Integer tempoBusca) {
        return estatisticasService.calcularEstatisticasTrasacoes(tempoBusca);
    }
}
