package com.microservice.user.service;

import com.microservice.user.dto.SkillDto;

import java.util.List;
import java.util.Optional;

public interface ISkillService {

    /**
     * @param skillDto
     */
    void addSkill(SkillDto skillDto);

    /**
     * @param skillDto
     */
    void removeSkill(SkillDto skillDto);

    /**
     * @param skillDto
     */
    void updateSkill(SkillDto skillDto);

    /**
     * @param skillDto
     */
    Optional<SkillDto> getSkill(SkillDto skillDto);

    /**
     * @param
     */
    Optional<List<SkillDto>> getSkills();

    /**
     * @param userid
     */
    Optional<List<SkillDto>> findSkillsByUserId(String userid);

    /**
     * @param skillname
     */
    Optional<SkillDto> findBySkillName(String skillname);


}
