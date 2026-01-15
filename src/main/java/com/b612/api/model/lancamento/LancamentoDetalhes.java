package com.b612.api.model.lancamento;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tb_lancamento_detalhes")
public class LancamentoDetalhes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- PRODUTO & EVENTO ---
    private String nomeEvento;
    private String promessa;
    private String formato;
    private String produtoOfertado;
    private Double precoTicket;
    
    // --- PÚBLICO ALVO ---
    private String avatarDescricao;
    private String faixaEtaria;
    private String sexoPredominante;
    private String interesses;
    private boolean publicoFrio;
    private boolean publicoQuente;

    // --- DATAS CRÍTICAS ---
    private LocalDate inicioCaptacao;
    private LocalDate fimCaptacao;
    private LocalDate dataEventoInicio;
    private LocalDate dataEventoFim;
    private LocalDate aberturaCarrinho;
    private LocalDate fechamentoCarrinho;
    @ElementCollection
    private List<LocalDate> datasAulas;

    // --- LINKS (Páginas) ---
    @ElementCollection
    private List<String> paginasCaptacao;
    
    @ElementCollection
    private List<String> paginasObrigado;
    
    @ElementCollection
    private List<String> paginasVendas;
    
    @ElementCollection
    private List<String> paginasCheckout;
    
    private String linkPastaMateriais;
    private String linkGrupoWhatsapp;
}