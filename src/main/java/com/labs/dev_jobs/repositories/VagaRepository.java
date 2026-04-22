package com.labs.dev_jobs.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.labs.dev_jobs.domain.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, UUID> {

}
