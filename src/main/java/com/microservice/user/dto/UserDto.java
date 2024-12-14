package com.microservice.user.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class UserDto {
    private Long userId;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String description;
    private String education;
    private String profileImage;
    private String role;
    private String accountStatus;

    private List<SkillDto> skills = new ArrayList<SkillDto>();

    private List<JobDto> jobs = new ArrayList<JobDto>();
}
