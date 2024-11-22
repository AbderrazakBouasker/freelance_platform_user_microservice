package com.microservice.user.service.impl;

import com.microservice.user.dto.ResponseDto;
import com.microservice.user.dto.SkillDto;
import com.microservice.user.entity.SkillEntity;
import com.microservice.user.entity.UserEntity;
import com.microservice.user.exception.SkillAlreadyExistException;
import com.microservice.user.mapper.SkillMapper;
import com.microservice.user.repository.SkillRepository;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.ISkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SkillService implements ISkillService {

    private SkillRepository skillRepository;

    private UserRepository userRepository;

    /**
     * @param skillDto
     */
    @Override
    public ResponseDto addSkill(Long userId, SkillDto skillDto) {
        // add the skill for the user
        // find the Skill by skill name and user id
        skillRepository.findBySkillNameAndUser_UserId(skillDto.getSkillName(), userId).ifPresent(skillEntity -> {
            throw new SkillAlreadyExistException("Skill Name already exist" + skillDto.getSkillName());
        });

        // create skill for the user
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // map skillDto to skillEntity
        SkillEntity skillEntity = new SkillEntity();
        SkillMapper.mapToSkillEntity(skillDto, skillEntity);
        skillEntity.setUser(user);

        // save skillEntity
        skillRepository.save(skillEntity);

        return new ResponseDto("201", "Skill added successfully");
    }

    /**
     * @param skillId
     */
    @Override
    public ResponseDto removeSkill(Long skillId) {
        Optional<SkillEntity> optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()) {
            skillRepository.delete(optionalSkill.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill not found");
        }
        return new ResponseDto("200", "Skill removed successfully");
    }

    /**
     * @param skillDto
     */
    @Override
    public ResponseDto updateSkill(SkillDto skillDto) {
        Optional<SkillEntity> optionalSkill = skillRepository.findById(skillDto.getSkillId());
        if (optionalSkill.isPresent()) {
            skillRepository.save(SkillMapper.mapToSkillEntity(skillDto, new SkillEntity()));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill not found");
        }
        return new ResponseDto("200", "Skill updated successfully");
    }

    /**
     * @param skillId
     */
    @Override
    public Optional<SkillDto> getSkill(Long skillId) {
        Optional<SkillEntity> optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()){
            return Optional.of(SkillMapper.mapToSkillDto(optionalSkill.get(),new SkillDto()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill not found");
    }

    /**
     * @param
     */
    @Override
    public List<SkillDto> getSkills() {
        List<SkillDto> skillDtos = new ArrayList<SkillDto>();
        skillRepository.findAll().forEach(skillEntity -> {
            SkillDto skillDto = new SkillDto();
            SkillMapper.mapToSkillDto(skillEntity,skillDto);
            skillDtos.add(skillDto);
        });
        return skillDtos;
    }

    /**
     * @param userid
     */
    @Override
    public List<SkillDto>  findSkillsByUserId(Long userid) {
        List<SkillDto> skillDtos = new ArrayList<SkillDto>();
        skillRepository.findByUser_UserId(userid).forEach(skillEntity -> {
            SkillDto skillDto = new SkillDto();
            SkillMapper.mapToSkillDto(skillEntity,skillDto);
            skillDtos.add(skillDto);
        });
        return skillDtos;
    }

    /**
     * @param skillId
     */
    @Override
    public Optional<SkillDto> findBySkillId(Long skillId) {
        Optional<SkillEntity> optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()){
            return Optional.of(SkillMapper.mapToSkillDto(optionalSkill.get(),new SkillDto()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill not found");
    }
}
