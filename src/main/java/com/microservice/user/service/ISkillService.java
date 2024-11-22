package com.microservice.user.service;

import com.microservice.user.dto.ResponseDto;
import com.microservice.user.dto.SkillDto;

import java.util.List;
import java.util.Optional;

public interface ISkillService {

    /**
     * @param skillDto
     */
    ResponseDto addSkill(Long userId, SkillDto skillDto);

    /**
     * @param skillId
     */
    ResponseDto removeSkill(Long skillId);

    /**
     * @param skillDto
     */
    ResponseDto updateSkill(SkillDto skillDto);

    /**
     * @param skillId
     */
    Optional<SkillDto> getSkill(Long skillId);

    /**
     * @param
     */
    List<SkillDto> getSkills();

    /**
     * @param userid
     */
    List<SkillDto> findSkillsByUserId(Long userid);

    /**
     * @param skillId
     */
    Optional<SkillDto> findBySkillId(Long skillId);

}
