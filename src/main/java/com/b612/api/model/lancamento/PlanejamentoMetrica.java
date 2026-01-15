package com.b612.api.model.lancamento;

import com.b612.api.model.config.CanalTrafego;
import com.b612.api.model.config.EtapaLancamento;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_planejamento_metrica")
public class PlanejamentoMetrica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lancamento_id")
    private Lancamento lancamento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cenario_id")
    private LancamentoCenario cenario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "etapa_id")
    private EtapaLancamento etapa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "canal_id")
    private CanalTrafego canal;

    private BigDecimal investimento;
    private BigDecimal faturamento;
    private Integer leads;
    private Integer vendas;
}

