package com.financeiro.api.dto;

import com.financeiro.api.model.TipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {

    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "O tipo de transação é obrigatório")
    private TipoTransacao tipo;

    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;

    private LocalDateTime dataHora;
}