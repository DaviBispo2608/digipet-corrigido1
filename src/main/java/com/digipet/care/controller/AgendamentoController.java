package com.digipet.care.controller;

import com.digipet.care.domain.Agendamento;
import com.digipet.care.service.AgendamentoService;
import com.digipet.care.web.AgendamentoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clinicas/{clinicaId}/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listar(@PathVariable Long clinicaId) {
        List<Agendamento> agendamentos = service.listarAgendamentosDaClinica(clinicaId);
        return ResponseEntity.ok(agendamentos);
    }

    @PostMapping
    public ResponseEntity<Agendamento> criar(@PathVariable Long clinicaId,
            @Valid @RequestBody AgendamentoRequest agendamento) {
        Agendamento novo = service.criarAgendamento(agendamento, clinicaId);
        return ResponseEntity.status(201).body(novo);
    }
}
