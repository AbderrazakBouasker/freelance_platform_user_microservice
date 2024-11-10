package com.microservice.user.service;

import com.microservice.user.dto.UserDto;

public interface IUserService {

    /**
     * @param userDto
     */
    void addUser(UserDto userDto);

    /**
     * @param userDto
     */
    void removeUser(UserDto userDto);

    /**
     * @param userDto
     */
    void updateUser(UserDto userDto);

    /**
     * @param userDto
     */
    void getUser(UserDto userDto);

    /**
     * @param userDto
     */
    void getUsers(UserDto userDto);

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
