package com.microservice.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
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

    // portfolio
    @OneToMany(mappedBy = "user")
    private List<SkillEntity> skills = new ArrayList<SkillEntity>();

    @Transient
    private List<JobEntity> jobs =  new ArrayList<JobEntity>();
}
