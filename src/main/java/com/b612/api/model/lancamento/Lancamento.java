package com.b612.api.model.lancamento;

import com.b612.api.model.enums.StatusLancamento;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "tb_lancamentos")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigo;
    private String modeloLancamento;

    @Enumerated(EnumType.STRING)
    private StatusLancamento status;

    // --- RELACIONAMENTOS ---

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalhes_id")
    private LancamentoDetalhes detalhes;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "investimentoTotal", column = @Column(name = "plan_inv_total")),
            @AttributeOverride(name = "faturamentoTotal", column = @Column(name = "plan_fat_total")),
    })
    private CenarioFinanceiro financeiroPlanejado;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "investimentoTotal", column = @Column(name = "real_inv_total")),
            @AttributeOverride(name = "faturamentoTotal", column = @Column(name = "real_fat_total")),
    })
    private CenarioFinanceiro financeiroReal;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LancamentoMetrica> metricas;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
    private List<DadosDiarios> historicoDiario;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
    private List<PerformanceCriativo> melhoresCriativos;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LancamentoCenario> cenarios;
}
