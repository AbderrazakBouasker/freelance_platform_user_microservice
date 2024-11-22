package com.microservice.user.dto;

import lombok.Data;

@Data
public class SkillDto {
    private Long skillId;
    private String skillName;
    private String skillDescription;
}
