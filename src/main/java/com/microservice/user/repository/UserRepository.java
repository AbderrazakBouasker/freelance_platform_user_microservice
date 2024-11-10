package com.microservice.user.repository;

import com.microservice.user.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByMobileNumber(String mobileNumber);
    Optional<UserEntity> findByUserName(String userName);
    @Query("SELECT u FROM UserEntity u JOIN u.portfolio p JOIN p.skills s WHERE s.skillName = :skillName")
    List<UserEntity> findUsersBySkillName(@Param("skillName") String skillName);
}
