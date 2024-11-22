package com.microservice.user.service;

import com.microservice.user.dto.ResponseDto;
import com.microservice.user.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    /**
     * @param userDto
     */
    ResponseDto addUser(UserDto userDto);

    /**
     * @param userId
     */
    ResponseDto removeUser(Long userId);

    /**
     * @param userDto
     */
    ResponseDto updateUser(UserDto userDto);


    /**
     * @param
     */
    List<UserDto> getUsers();

    /**
     * @param userid
     */
    Optional<UserDto> findUserByUserId(Long userid);

    /**
     * @param username
     */
    Optional<UserDto> findByUserName(String username);

}
