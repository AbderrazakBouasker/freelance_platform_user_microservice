package com.microservice.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class SkillEntity {

    @Id
    private int skillId;
    private String skillName;
    private String skillDescription;
    @ManyToMany(mappedBy = "skills")
    private List<PortfolioEntity> portfolios;
}
