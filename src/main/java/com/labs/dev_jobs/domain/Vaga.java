package com.labs.dev_jobs.domain;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vagas")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    
    // Permite textos longos na descrição
    @Column(columnDefinition = "TEXT") 
    private String descricao;
    
    private Boolean isRemoto;
    private String stackPrincipal;

    // Relacionamento: Várias vagas podem pertencer a UMA empresa (Muitos-para-Um)
    @ManyToOne 
    // Nome da coluna de chave estrangeira no MySQL
    @JoinColumn(name = "empresa_id") 
    private Empresa empresa;
}
