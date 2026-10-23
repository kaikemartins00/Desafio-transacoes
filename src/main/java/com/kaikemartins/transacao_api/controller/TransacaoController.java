package com.kaikemartins.transacao_api.controller;

import com.kaikemartins.transacao_api.business.services.TransacaoService;
import com.kaikemartins.transacao_api.controller.dtos.TransacaoRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {


    private final TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Endpoint para criar trasacoes")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Transacao criada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Campos nao atendem os requisitos da transacao"),
            @ApiResponse(responseCode = "400", description = "Erro de requisicao"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")})
    public void criarTransacao(@Valid @RequestBody TransacaoRequestDto transacaoRequestDto) {
        transacaoService.criarTransacao(transacaoRequestDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Endpoint para deletar trasacoes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Transacoes deletadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisicao"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")})
    public void deletarTransacao() {
        transacaoService.deletarTransacao();
    }

}
