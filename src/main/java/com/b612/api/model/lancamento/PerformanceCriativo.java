package com.b612.api.model.lancamento;

import com.b612.api.model.config.CanalTrafego;
import com.b612.api.model.config.EtapaLancamento;
import com.b612.api.model.enums.OrigemDado;
import com.b612.api.model.enums.TipoMidia;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_performance_criativos")
public class PerformanceCriativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String externalId;
    private String nomeAnuncio;
    
    @Enumerated(EnumType.STRING)
    private TipoMidia tipo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "etapa_id")
    private EtapaLancamento etapa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "canal_id")
    private CanalTrafego canal;

    // Métricas
    private Double valorGasto;
    private Integer resultados;
    private Double custoPorResultado;
    private Double ctr;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrigemDado origem;

    @ManyToOne
    @JoinColumn(name = "lancamento_id")
    private Lancamento lancamento;
}
