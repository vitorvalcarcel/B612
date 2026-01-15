package com.b612.api.model.lancamento;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class CenarioFinanceiro {

    // --- TOTAIS GERAIS DO CENÁRIO (SNAPSHOTS) ---
    // Estes valores devem ser recalculados a partir da lista de LancamentoMetrica
    // idealmente,
    // mas podem ser persistidos para facilidade de consulta (cache).

    private Double investimentoTotal;
    private Double faturamentoTotal;
    private Double lucroLiquido;
    private Double roas; // Return on Ad Spend
    private Double custoPorLeadMedio;
    private Double custoPorVenda;
    private Integer leadsTotal;
    private Integer vendasTotal;

    // Campos de detalhe por etapa foram removidos em favor de LancamentoMetrica
}