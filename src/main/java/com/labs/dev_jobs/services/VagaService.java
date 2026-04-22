package com.labs.dev_jobs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.dev_jobs.domain.Empresa;
import com.labs.dev_jobs.domain.Vaga;
import com.labs.dev_jobs.dto.VagaRequestDTO;
import com.labs.dev_jobs.repositories.EmpresaRepository;
import com.labs.dev_jobs.repositories.VagaRepository;

@Service
public class VagaService {
    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    // Método para criar uma nova vaga
    public Vaga criarVaga(VagaRequestDTO dados) {
        // 1. Buscamos a empresa no banco de dados pelo ID enviado no DTO
        // Se não encontrar, lança um erro.
        Empresa empresa = empresaRepository.findById(dados.empresaId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        // 2. Montamos o objeto Entidade Vaga com os dados do DTO
        Vaga novaVaga = new Vaga();
        novaVaga.setTitulo(dados.titulo());
        novaVaga.setDescricao(dados.descricao());
        novaVaga.setIsRemoto(dados.isRemoto());
        novaVaga.setStackPrincipal(dados.stackPrincipal());
        
        // 3. Associamos a empresa encontrada à vaga
        novaVaga.setEmpresa(empresa);

        // 4. Salvamos no banco e retornamos a vaga criada
        return vagaRepository.save(novaVaga);
    }

    // Método simples para listar todas as vagas
    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

}   
