package com.microservice.user.dto;

import com.microservice.user.entity.SkillEntity;
import lombok.Data;

import java.util.List;

@Data
public class PortfolioDto {
    private List<SkillDto> skills;
    private List<JobDto> jobs;
}
