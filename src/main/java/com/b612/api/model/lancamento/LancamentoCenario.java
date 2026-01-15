package com.b612.api.model.lancamento;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_lancamento_cenario")
public class LancamentoCenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lancamento_id")
    private Lancamento lancamento;

    @Column(nullable = false)
    private String nome;

    private String descricao;
}

