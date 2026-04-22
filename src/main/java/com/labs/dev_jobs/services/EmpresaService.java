package com.labs.dev_jobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.dev_jobs.domain.Empresa;
import com.labs.dev_jobs.dto.EmpresaRequestDTO;
import com.labs.dev_jobs.repositories.EmpresaRepository;

@Service // Indica que é um serviço gerenciado pelo Spring
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa criarEmpresa(EmpresaRequestDTO dto) {
        // Cria uma nova instância da entidade Empresa
        Empresa novaEmpresa = new Empresa();

        // Copia os dados do DTO para a Entidade
        novaEmpresa.setNome(dto.nome());
        novaEmpresa.setSite(dto.site());
        novaEmpresa.setCidade(dto.cidade());

        // Salva no banco de dados e retorna a empresa com o ID gerado
        return empresaRepository.save(novaEmpresa);
    }

    public java.util.List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }
}