package com.microservice.user.service.impl;

import com.microservice.user.dto.ResponseDto;
import com.microservice.user.dto.UserDto;
import com.microservice.user.entity.UserEntity;
import com.microservice.user.exception.UserAlreadyExistException;
import com.microservice.user.mapper.UserMapper;
import com.microservice.user.openfeign.JobFeign;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private UserRepository userRepository;
    private JobFeign jobFeign;

    /**
     * @param userDto
     * @apiNote "interface for create user service takes userDTO"
     */
    @Override
    public ResponseDto addUser(UserDto userDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userDto.getUserName());
        if (optionalUserEntity.isPresent()) {
            throw new UserAlreadyExistException("User Name already exist " + userDto.getUserName());
        }
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto, new UserEntity());
        userRepository.save(userEntity);

        return new ResponseDto("201", "User added successfully");
    }

    /**
     * @param userId
     */
    @Override
    public ResponseDto removeUser(Long userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (optionalUserEntity.isPresent()) {
            userRepository.deleteById(userId);
            return new ResponseDto("200", "User deleted successfully");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    /**
     * @param userDto
     */
    @Override
    public ResponseDto updateUser(UserDto userDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userDto.getUserId());
        if (optionalUserEntity.isPresent()) {
            // check if the userName was updated, if it was changed, throw ResponseStatusError
            if (!optionalUserEntity.get().getUserName().equals(userDto.getUserName())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Name cannot be updated");
            }
            UserEntity userEntity = UserMapper.mapToUserEntity(userDto, optionalUserEntity.get());
            userRepository.save(userEntity);
            return new ResponseDto("200", "User updated successfully");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


    /**
     *
     */
    @Override
    public List<UserDto> getUsers() {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        userRepository.findAll().forEach(userEntity -> {
            UserDto userDto = new UserDto();
            UserMapper.mapToUserDto(userEntity, userDto);
            // fetch jobs from job service
            userDto.setJobs(jobFeign.getAllJobsByUser(userEntity.getUserId()));
            userDtos.add(userDto);
        });
        return userDtos;
    }

    /**
     * @param userid
     */
    @Override
    public Optional<UserDto> findUserByUserId(Long userid) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userid);
        if (optionalUserEntity.isPresent()) {
            UserDto userDto = new UserDto();
            UserMapper.mapToUserDto(optionalUserEntity.get(), userDto);
            // fetch jobs from job service
            userDto.setJobs(jobFeign.getAllJobsByUser(userid));
            return Optional.of(userDto);
        } else {
            return Optional.empty();
        }
    }

    /**
     * @param username
     */
    @Override
    public Optional<UserDto> findByUserName(String username) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(username);
        if (optionalUserEntity.isPresent()) {
            UserDto userDto = new UserDto();
            UserMapper.mapToUserDto(optionalUserEntity.get(), userDto);
            // fetch jobs from job service
            userDto.setJobs(jobFeign.getAllJobsByUser(optionalUserEntity.get().getUserId()));
            return Optional.of(userDto);
        } else {
            return Optional.empty();
        }

    }

}
