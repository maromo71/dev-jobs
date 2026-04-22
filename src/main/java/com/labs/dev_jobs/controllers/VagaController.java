package com.labs.dev_jobs.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.labs.dev_jobs.domain.Vaga;
import com.labs.dev_jobs.dto.VagaRequestDTO;
import com.labs.dev_jobs.services.VagaService;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    // Endpoint POST para criar uma vaga
    @PostMapping
    public ResponseEntity<Vaga> criar(@RequestBody VagaRequestDTO dto) {
        Vaga novaVaga = vagaService.criarVaga(dto);
        // Retorna status 200 OK com os dados da vaga criada
        return ResponseEntity.ok(novaVaga);
    }

    // Endpoint GET para listar as vagas
    @GetMapping
    public ResponseEntity<List<Vaga>> listar() {
        List<Vaga> vagas = vagaService.listarTodas();
        return ResponseEntity.ok(vagas);
    }
}
