package com.kaikemartins.transacao_api.controller.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.OffsetDateTime;

public record TransacaoRequestDto(
        @NotNull @PositiveOrZero Double valor,
        @NotNull @PastOrPresent OffsetDateTime dataHora
) {
}
