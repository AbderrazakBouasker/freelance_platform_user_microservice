package com.microservice.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class UserEntity {

    @Id
    private int userId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String description;
    private String education;
    private String profileImage;
    private String role;
    private String accountStatus;
    @OneToOne
    private PortfolioEntity portfolio;
}
