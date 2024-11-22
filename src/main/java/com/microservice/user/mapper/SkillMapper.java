package com.microservice.user.mapper;

import com.microservice.user.dto.SkillDto;
import com.microservice.user.entity.SkillEntity;

import java.util.ArrayList;
import java.util.List;

public class SkillMapper {

    public static SkillDto mapToSkillDto(SkillEntity skillEntity, SkillDto skillDto) {
        skillDto.setSkillId(skillEntity.getSkillId());
        skillDto.setSkillName(skillEntity.getSkillName());
        skillDto.setSkillDescription(skillEntity.getSkillDescription());
        return skillDto;
    }

    public static SkillEntity mapToSkillEntity(SkillDto skillDto, SkillEntity skillEntity) {
        skillEntity.setSkillId(skillDto.getSkillId());
        skillEntity.setSkillName(skillDto.getSkillName());
        skillEntity.setSkillDescription(skillDto.getSkillDescription());
        return skillEntity;
    }

    public static List<SkillDto> mapToSkillDtoList(List<SkillEntity> skillEntities) {
        List<SkillDto> skillDtos = new ArrayList<>();
        for (SkillEntity skillEntity : skillEntities) {
            skillDtos.add(mapToSkillDto(skillEntity, new SkillDto()));
        }
        return skillDtos;
    }

    public static List<SkillEntity> mapToSkillEntityList(List<SkillDto> skillDtos) {
        List<SkillEntity> skillEntities = new ArrayList<>();
        for (SkillDto skillDto : skillDtos) {
            skillEntities.add(mapToSkillEntity(skillDto, new SkillEntity()));
        }
        return skillEntities;
    }
}
