package com.b612.api.model.lancamento;

import com.b612.api.model.config.CanalTrafego;
import com.b612.api.model.config.EtapaLancamento;
import com.b612.api.model.enums.OrigemDado;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_dados_diarios")
public class DadosDiarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @ManyToOne(optional = false)
    @JoinColumn(name = "etapa_id")
    private EtapaLancamento etapa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "canal_id")
    private CanalTrafego canal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrigemDado origem;

    // CAPTAÇÃO DO DIA
    private Double investimentoDia;
    private Integer leadsCaptados;
    private Double cplDia;
    private Integer cliquesPaginaCaptacao;
    private Double taxaConversaoPaginaCaptacao;

    // VENDAS DO DIA
    private Integer vendasDia;
    private Double faturamentoDia;
    private Integer iniciaramCheckout;
    private Integer boletosGerados;
    private Integer pixGerados;

    @ManyToOne
    @JoinColumn(name = "lancamento_id")
    private Lancamento lancamento;
}
