package com.microservice.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    private String skillName;
    private String skillDescription;
    @ManyToMany(mappedBy = "skills")
    private List<PortfolioEntity> portfolios;
}
