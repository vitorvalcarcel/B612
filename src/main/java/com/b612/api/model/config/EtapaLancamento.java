package com.b612.api.model.config;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_etapa_lancamento")
public class EtapaLancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    @Column(name = "padrao_sistema", nullable = false)
    private boolean padraoSistema = false;
}
