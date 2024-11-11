package com.microservice.user.service.impl;

import com.microservice.user.dto.UserDto;
import com.microservice.user.entity.UserEntity;
import com.microservice.user.exception.UserAlreadyExistException;
import com.microservice.user.mapper.UserMapper;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private UserRepository userRepository;

    /**
     * @param userDto
     * @apiNote "interface for create user service takes userDTO"
     */
    @Override
    public void addUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto, new UserEntity());
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userDto.getUserName());
        if (optionalUserEntity.isPresent()) {
            throw new UserAlreadyExistException("User Name already exist" + userDto.getUserName());
        }
        userEntity.setUserName(userDto.getUserName());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setMobileNumber(userDto.getMobileNumber());
        userEntity.setDescription(userDto.getDescription());
        userEntity.setEducation(userDto.getEducation());
        userEntity.setProfileImage(userDto.getProfileImage());
        userEntity.setRole(userDto.getRole());
        userEntity.setAccountStatus(userDto.getAccountStatus());
        userRepository.save(userEntity);
    }

    /**
     * @param userDto
     */
    @Override
    public void removeUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto, new UserEntity());
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userDto.getUserName());
        if (optionalUserEntity.isPresent()) {
            userRepository.delete(userEntity);
        }else{
            throw new UserAlreadyExistException("User Name does not exist" + userDto.getUserName());
        }
    }

    /**
     * @param userDto
     */
    @Override
    public void updateUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto, new UserEntity());
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userDto.getUserName());
        if (optionalUserEntity.isPresent()) {
            userEntity.setUserName(userDto.getUserName());
            userEntity.setFirstName(userDto.getFirstName());
            userEntity.setLastName(userDto.getLastName());
            userEntity.setMobileNumber(userDto.getMobileNumber());
            userEntity.setDescription(userDto.getDescription());
            userEntity.setEducation(userDto.getEducation());
            userEntity.setProfileImage(userDto.getProfileImage());
            userEntity.setRole(userDto.getRole());
            userEntity.setAccountStatus(userDto.getAccountStatus());
            userRepository.save(userEntity);
        }else{
            throw new UserAlreadyExistException("User Name does not exist" + userDto.getUserName());
        }
    }


    /**
     *
     */
    @Override
    public Optional<List<UserDto>> getUsers() {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        userRepository.findAll().forEach(userEntity -> {
            UserDto userDto = new UserDto();
            UserMapper.mapToUserDto(userEntity,userDto);
            userDtos.add(userDto);
        });
        return Optional.of(userDtos);
    }

    /**
     * @param userid
     */
    @Override
    public Optional<UserDto> findUserByUserId(String userid) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(Long.parseLong(userid));
        if (optionalUserEntity.isPresent()){
            UserDto userDto = new UserDto();
            UserMapper.mapToUserDto(optionalUserEntity.get(),userDto);
            return Optional.of(userDto);
        }
        else {
            return Optional.empty();
        }
    }

    /**
     * @param username
     */
    @Override
    public Optional<UserDto> findByUserName(String username) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(username);
        if (optionalUserEntity.isPresent()){
            UserDto userDto = new UserDto();
            UserMapper.mapToUserDto(optionalUserEntity.get(),userDto);
            return Optional.of(userDto);
        }
        else {
            return Optional.empty();
        }

    }

    /**
     * @param skillname
     */
    @Override
    public Optional<List<UserDto>> findUsersBySkillName(String skillname) {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        userRepository.findUsersBySkillName(skillname).forEach(userEntity -> {
            UserDto userDto = new UserDto();
            UserMapper.mapToUserDto(userEntity,userDto);
            userDtos.add(userDto);
        });
        return Optional.of(userDtos);
    }

}
