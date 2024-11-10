package com.microservice.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class PortfolioEntity {

    @Id
    private int portfolioId;
    @ManyToMany
    @JoinTable(
            name = "portfolio_skill",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<SkillEntity> skills;
    @Transient
    private List<JobEntity> jobs;
}
