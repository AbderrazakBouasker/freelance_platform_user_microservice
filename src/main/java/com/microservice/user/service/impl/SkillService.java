package com.microservice.user.service.impl;

import com.microservice.user.dto.SkillDto;
import com.microservice.user.entity.SkillEntity;
import com.microservice.user.exception.SkillAlreadyExistException;
import com.microservice.user.mapper.SkillMapper;
import com.microservice.user.repository.SkillRepository;
import com.microservice.user.service.ISkillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SkillService implements ISkillService {

    private SkillRepository skillRepository;

    /**
     * @param skillDto
     */
    @Override
    public void addSkill(SkillDto skillDto) {
        Optional<SkillEntity> optionalSkill = skillRepository.findBySkillName(skillDto.getSkillName());
        if (optionalSkill.isPresent()) {
            throw new SkillAlreadyExistException("Skill Name already exist" + skillDto.getSkillName());
        }
        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setSkillName(skillDto.getSkillName());
        skillEntity.setSkillDescription(skillDto.getSkillDescription());
        skillRepository.save(skillEntity);
    }

    /**
     * @param skillDto
     */
    @Override
    public void removeSkill(SkillDto skillDto) {
        Optional<SkillEntity> optionalSkill = skillRepository.findBySkillName(skillDto.getSkillName());
        if (optionalSkill.isPresent()) {
            skillRepository.delete(optionalSkill.get());
        }else{
            throw new SkillAlreadyExistException("Skill Name does not exist" + skillDto.getSkillName());
        }
    }

    /**
     * @param skillDto
     */
    @Override
    public void updateSkill(SkillDto skillDto) {
        Optional<SkillEntity> optionalSkill = skillRepository.findBySkillName(skillDto.getSkillName());
        if (optionalSkill.isPresent()) {
            skillRepository.save(SkillMapper.mapToSkillEntity(skillDto, new SkillEntity()));
        }else{
            throw new SkillAlreadyExistException("Skill Name does not exist" + skillDto.getSkillName());
        }
    }

    /**
     * @param skillDto
     */
    @Override
    public Optional<SkillDto> getSkill(SkillDto skillDto) {
        Optional<SkillEntity> optionalSkill = skillRepository.findBySkillName(skillDto.getSkillName());
        if (optionalSkill.isPresent()){
            return Optional.of(SkillMapper.mapToSkillDto(optionalSkill.get(),new SkillDto()));
        }
        throw new SkillAlreadyExistException("Skill Name does not exist" + skillDto.getSkillName());
    }

    /**
     * @param
     */
    @Override
    public Optional<List<SkillDto>> getSkills() {
        List<SkillDto> skillDtos = new ArrayList<SkillDto>();
        skillRepository.findAll().forEach(skillEntity -> {
            SkillDto skillDto = new SkillDto();
            SkillMapper.mapToSkillDto(skillEntity,skillDto);
            skillDtos.add(skillDto);
        });
        return Optional.of(skillDtos);
    }

    /**
     * @param userid
     */
    @Override
    public Optional<List<SkillDto>>  findSkillsByUserId(String userid) {
        List<SkillDto> skillDtos = new ArrayList<SkillDto>();
        skillRepository.findSkillsByUserId(Long.parseLong(userid)).ifPresent(skillEntities -> {
            skillEntities.forEach(skillEntity -> {
                SkillDto skillDto = new SkillDto();
                SkillMapper.mapToSkillDto(skillEntity,skillDto);
                skillDtos.add(skillDto);
            });
        });
        return Optional.of(skillDtos);
    }

    /**
     * @param skillname
     */
    @Override
    public Optional<SkillDto>  findBySkillName(String skillname) {
        Optional<SkillEntity> optionalSkillEntity = skillRepository.findBySkillName(skillname);
        if (optionalSkillEntity.isPresent()) {
            SkillDto skillDto = new SkillDto();
            SkillMapper.mapToSkillDto(optionalSkillEntity.get(), skillDto);
            return Optional.of(skillDto);
        } else {
            throw new SkillAlreadyExistException("Skill Name does not exist" + skillname);

        }
    }
}
