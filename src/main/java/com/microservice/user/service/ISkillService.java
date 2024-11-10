package com.microservice.user.service;

public interface ISkillService {

    /**
     * @param skill
     */
    void addSkill(String skill);

    /**
     * @param skill
     */
    void removeSkill(String skill);

    /**
     * @param skill
     */
    void updateSkill(String skill);

    /**
     * @param skill
     */
    void getSkill(String skill);

    /**
     * @param skill
     */
    void getSkills(String skill);

    /**
     * @param userid
     */
    void findSkillsByUserId(String userid);

    /**
     * @param skillname
     */
    void findBySkillName(String skillname);


}
