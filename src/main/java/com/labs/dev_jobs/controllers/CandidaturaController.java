package com.labs.dev_jobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.dev_jobs.domain.Candidatura;
import com.labs.dev_jobs.dto.CandidaturaRequestDTO;
import com.labs.dev_jobs.services.CandidaturaService;

@RestController // 1. Indica que é um controlador de API REST
@RequestMapping("/api/candidaturas") // 2. Define a rota base no navegador/Postman
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    // Endpoint POST para o dev se candidatar a uma vaga
    @PostMapping
    public ResponseEntity<Candidatura> aplicar(@RequestBody CandidaturaRequestDTO dto) {

        // Repassa os dados recebidos no JSON para a camada de Serviço
        Candidatura novaCandidatura = candidaturaService.aplicar(dto);

        // Retorna Status 201 (Created) e os dados da candidatura salva (com a data
        // gerada)
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCandidatura);
    }

    @GetMapping
    public ResponseEntity<java.util.List<Candidatura>> listar() {
        return ResponseEntity.ok(candidaturaService.listarTodas());
    }
}