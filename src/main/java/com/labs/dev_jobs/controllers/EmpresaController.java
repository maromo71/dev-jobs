package com.labs.dev_jobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.dev_jobs.domain.Empresa;
import com.labs.dev_jobs.dto.EmpresaRequestDTO;
import com.labs.dev_jobs.services.EmpresaService;

@RestController // Indica que é um Controlador REST
@RequestMapping("/api/empresas") // Rota base para este controlador
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // Endpoint POST para criar uma empresa
    @PostMapping
    public ResponseEntity<Empresa> criar(@RequestBody EmpresaRequestDTO dto) {
        Empresa novaEmpresa = empresaService.criarEmpresa(dto);
        // Retorna o status 200 OK com o objeto da empresa criada (incluindo o ID)
        return ResponseEntity.ok(novaEmpresa);
    }

    @GetMapping
    public ResponseEntity<java.util.List<Empresa>> listar() {
        return ResponseEntity.ok(empresaService.listarTodas());
    }
}