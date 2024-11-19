package com.microservice.user.dto;

import com.microservice.user.entity.PortfolioEntity;
import lombok.Data;


@Data
public class UserDto {
    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String description;
    private String education;
    private String profileImage;
    private String role;
    private String accountStatus;
    private PortfolioEntity portfolio;
}
