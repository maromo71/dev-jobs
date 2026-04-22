package com.labs.dev_jobs.dto;

import java.util.UUID;

public record VagaRequestDTO(
    String titulo,
    String descricao,
    Boolean isRemoto,
    String stackPrincipal,
    UUID empresaId
) // Recebemos apenas o ID da empresa para vinculá-la à vaga
{}
