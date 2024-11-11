package com.microservice.user.mapper;

import com.microservice.user.dto.PortfolioDto;
import com.microservice.user.entity.PortfolioEntity;

public class PortfolioMapper {

    public static PortfolioDto mapToPortfolioDto(PortfolioEntity portfolioEntity, PortfolioDto portfolioDto) {
        portfolioDto.setJobs(JobMapper.mapToJobDtoList(portfolioEntity.getJobs()));
        portfolioDto.setSkills(SkillMapper.mapToSkillDtoList(portfolioEntity.getSkills()));
        return portfolioDto;
    }

    public static PortfolioEntity mapToPortfolioEntity(PortfolioDto portfolioDto, PortfolioEntity portfolioEntity) {
        portfolioEntity.setJobs(JobMapper.mapToJobEntityList(portfolioDto.getJobs()));
        portfolioEntity.setSkills(SkillMapper.mapToSkillEntityList(portfolioDto.getSkills()));
        return portfolioEntity;
    }
}
