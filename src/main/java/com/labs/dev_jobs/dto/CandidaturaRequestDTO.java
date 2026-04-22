package com.labs.dev_jobs.dto;

import java.util.UUID;

public record CandidaturaRequestDTO(
    String linkedinUrl,
    UUID vagaId
) {}