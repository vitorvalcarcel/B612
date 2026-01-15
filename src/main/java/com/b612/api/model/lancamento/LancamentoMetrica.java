package com.b612.api.model.lancamento;

import com.b612.api.model.config.EtapaLancamento;
import com.b612.api.model.config.CanalTrafego;
import com.b612.api.model.enums.OrigemDado;
import com.b612.api.model.enums.TipoDado;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_lancamento_metrica")
public class LancamentoMetrica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lancamento_id")
    private Lancamento lancamento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "etapa_id")
    private EtapaLancamento etapa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "canal_id")
    private CanalTrafego canal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDado tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrigemDado origem;

    // Métricas Financeiras
    private BigDecimal investimento;
    private BigDecimal faturamento;

    // Métricas de Volume
    private Integer leads;
    private Integer vendas;

    // Métricas Calculadas (Opcional persistir, mas bom para cache)
    // Pode-se deixar null e calcular em tempo de execução,
    // ou persistir snapshot. Por enquanto, focamos nos dados brutos.
}
