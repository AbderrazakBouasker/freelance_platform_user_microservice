package com.microservice.user.controller;

import com.microservice.user.dto.SkillDto;
import com.microservice.user.service.ISkillService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skills")
@AllArgsConstructor
public class SkillController {

    private final ISkillService skillService;

    @PostMapping("/add")
    public void addSkill(@RequestBody SkillDto skillDto) {
        skillService.addSkill(skillDto);
    }

    @DeleteMapping("/remove")
    public void removeSkill(@RequestBody SkillDto skillDto) {
        skillService.removeSkill(skillDto);
    }

    @PutMapping("/update")
    public void updateSkill(@RequestBody SkillDto skillDto) {
        skillService.updateSkill(skillDto);
    }

    @GetMapping("/all")
    public Optional<List<SkillDto>> getSkills() {
        return skillService.getSkills();
    }

    @GetMapping("/{userid}")
    public Optional<List<SkillDto>> findSkillsByUserId(@PathVariable String userid) {
        return skillService.findSkillsByUserId(userid);
    }

    @GetMapping("/skillname/{skillname}")
    public Optional<SkillDto> findBySkillName(@PathVariable String skillname) {
        return skillService.findBySkillName(skillname);
    }
}
