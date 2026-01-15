package com.b612.api.controller;

import com.b612.api.model.lancamento.Lancamento;
import com.b612.api.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoRepository repository;

    @GetMapping
    public List<Lancamento> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Lancamento criar(@RequestBody Lancamento lancamento) {
        return repository.save(lancamento);
    }
}