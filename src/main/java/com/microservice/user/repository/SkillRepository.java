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
    //Optional<SkillEntity> findByUserId(Long userId);
    /*@Query("SELECT s FROM SkillEntity s JOIN s.portfolios p JOIN p.user u WHERE u.userId = :userId")
    List<SkillEntity> findSkillsByUserId(@Param("userId") int userId);*/
    @Query("SELECT s FROM SkillEntity s JOIN s.portfolios p JOIN UserEntity u ON u.portfolio = p WHERE u.userId = :userId")
    Optional<List<SkillEntity>> findSkillsByUserId(@Param("userId") Long userId);
    Optional<SkillEntity> findBySkillName(String skillName);
}
