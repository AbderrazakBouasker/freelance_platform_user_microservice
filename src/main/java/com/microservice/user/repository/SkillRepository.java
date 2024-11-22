package com.microservice.user.repository;

import com.microservice.user.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {
    // find skills by skill name and user id
    Optional<SkillEntity> findBySkillNameAndUser_UserId(String skillName, Long userId);

    // find skills by skill name
    Optional<SkillEntity> findBySkillName(String skillName);

    // find skills by user id
    List<SkillEntity> findByUser_UserId(Long userId);
}
