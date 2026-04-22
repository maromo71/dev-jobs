package com.labs.dev_jobs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.labs.dev_jobs.domain.Candidatura;
import com.labs.dev_jobs.domain.Vaga;
import com.labs.dev_jobs.dto.CandidaturaRequestDTO;
import com.labs.dev_jobs.repositories.CandidaturaRepository;
import com.labs.dev_jobs.repositories.VagaRepository;

@Service
public class CandidaturaService {
    @Autowired
    private CandidaturaRepository repository;

    @Autowired
    private VagaRepository vagaRepository;

    public Candidatura aplicar(CandidaturaRequestDTO dto) {
        Vaga vaga = vagaRepository.findById(dto.vagaId())
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        Candidatura nova = new Candidatura();
        nova.setLinkedinUrl(dto.linkedinUrl());
        nova.setVaga(vaga);

        return repository.save(nova);
    }

    public List<Candidatura> listarTodas() {
        return repository.findAll(); // ou candidaturaRepository, dependendo de como você nomeou
    }
}
