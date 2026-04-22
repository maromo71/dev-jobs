package com.labs.dev_jobs.repositories;

import com.labs.dev_jobs.domain.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CandidaturaRepository extends JpaRepository<Candidatura, UUID> {}