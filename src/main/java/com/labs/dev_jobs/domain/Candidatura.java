package com.labs.dev_jobs.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "candidaturas")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Candidatura {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String linkedinUrl;
    
    private LocalDateTime dataAplicacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;
}