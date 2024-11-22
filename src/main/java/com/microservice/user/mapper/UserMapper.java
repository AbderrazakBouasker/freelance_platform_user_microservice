package com.microservice.user.mapper;

import com.microservice.user.dto.UserDto;
import com.microservice.user.entity.UserEntity;

public class UserMapper {

    public static UserDto mapToUserDto(UserEntity userEntity, UserDto userDto) {
        userDto.setUserId(userEntity.getUserId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setMobileNumber(userEntity.getMobileNumber());
        userDto.setDescription(userEntity.getDescription());
        userDto.setEducation(userEntity.getEducation());
        userDto.setProfileImage(userEntity.getProfileImage());
        userDto.setRole(userEntity.getRole());
        userDto.setAccountStatus(userEntity.getAccountStatus());
        userDto.setPortfolio(userEntity.getPortfolio());
        return userDto;
    }

    public static UserEntity mapToUserEntity(UserDto userDto, UserEntity userEntity) {
        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setMobileNumber(userDto.getMobileNumber());
        userEntity.setDescription(userDto.getDescription());
        userEntity.setEducation(userDto.getEducation());
        userEntity.setProfileImage(userDto.getProfileImage());
        userEntity.setRole(userDto.getRole());
        userEntity.setAccountStatus(userDto.getAccountStatus());
        userEntity.setPortfolio(userDto.getPortfolio());
        return userEntity;
    }
}
