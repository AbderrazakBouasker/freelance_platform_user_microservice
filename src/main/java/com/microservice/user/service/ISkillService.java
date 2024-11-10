package com.microservice.user.service;

import com.microservice.user.dto.SkillDto;

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
    void getSkill(SkillDto skillDto);

    /**
     * @param skillDto
     */
    void getSkills(SkillDto skillDto);

    /**
     * @param userid
     */
    void findSkillsByUserId(String userid);

    /**
     * @param skillname
     */
    void findBySkillName(String skillname);


}
