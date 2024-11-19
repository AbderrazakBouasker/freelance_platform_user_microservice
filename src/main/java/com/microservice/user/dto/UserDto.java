package com.microservice.user.dto;

import lombok.Data;
//todo: add a PortfolioDto object to UserDto
//todo: expose user id
//todo: update all the related Code (Mapper,...)

@Data
public class UserDto {
    private String userName;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String description;
    private String education;
    private String profileImage;
    private String role;
    private String accountStatus;
}
