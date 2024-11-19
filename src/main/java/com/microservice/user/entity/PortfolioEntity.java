package com.microservice.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class PortfolioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;
    @OneToOne(mappedBy = "portfolio")
    private UserEntity user;
    @ManyToMany
    @JoinTable(
            name = "portfolio_skill",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<SkillEntity> skills;

    private List<Long> jobIds;

    @Transient
    private List<JobEntity> jobs;
}
