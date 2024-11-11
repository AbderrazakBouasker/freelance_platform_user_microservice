package com.microservice.user.service;

import com.microservice.user.dto.UserDto;

import java.util.List;
import java.util.Optional;

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
     * @param
     */
    Optional<List<UserDto>> getUsers();

    /**
     * @param userid
     */
    Optional<UserDto> findUserByUserId(String userid);

    /**
     * @param username
     */
    Optional<UserDto> findByUserName(String username);

    /**
     * @param skillname
     */
    Optional<List<UserDto>> findUsersBySkillName(String skillname);
}
