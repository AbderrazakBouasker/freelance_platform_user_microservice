package com.microservice.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
//todo: dig deeper into jobs @Transient

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
    @Transient
    private List<JobEntity> jobs;
}
