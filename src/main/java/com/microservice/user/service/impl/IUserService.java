package com.microservice.user.service.impl;

public interface IUserService {

    /**
     * @param user
     */
    void addUser(String user);

    /**
     * @param user
     */
    void removeUser(String user);

    /**
     * @param user
     */
    void updateUser(String user);

    /**
     * @param user
     */
    void getUser(String user);

    /**
     * @param user
     */
    void getUsers(String user);

    /**
     * @param userid
     */
    void findUserByUserId(String userid);

    /**
     * @param username
     */
    void findByUserName(String username);

    /**
     * @param skillname
     */
    void findUsersBySkillName(String skillname);
}
