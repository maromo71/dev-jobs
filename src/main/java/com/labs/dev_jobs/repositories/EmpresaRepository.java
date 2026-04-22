package com.labs.dev_jobs.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.labs.dev_jobs.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, UUID>{

}
