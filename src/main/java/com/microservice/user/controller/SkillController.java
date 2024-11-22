package com.microservice.user.controller;

import com.microservice.user.dto.ResponseDto;
import com.microservice.user.dto.SkillDto;
import com.microservice.user.service.ISkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skills")
@AllArgsConstructor
public class SkillController {

    private final ISkillService skillService;

    @PostMapping("/{userid}")
    public ResponseEntity<ResponseDto> addSkill(@PathVariable Long userid, @RequestBody SkillDto skillDto) {
        return ResponseEntity.ok(skillService.addSkill(userid, skillDto));
    }

    @DeleteMapping("/{skillId}")
    public ResponseEntity<ResponseDto> removeSkill(@PathVariable Long skillId) {
        return ResponseEntity.ok(skillService.removeSkill(skillId));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateSkill(@RequestBody SkillDto skillDto) {
        return ResponseEntity.ok(skillService.updateSkill(skillDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<SkillDto>> getSkills() {
        return ResponseEntity.ok(skillService.getSkills());
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<SkillDto>> findSkillsByUserId(@PathVariable Long userid) {
        return ResponseEntity.ok(skillService.findSkillsByUserId(userid));
    }

    @GetMapping("/{skillId}")
    public ResponseEntity<Optional<SkillDto>> findBySkillId(@PathVariable Long skillId) {
        return ResponseEntity.ok(skillService.findBySkillId(skillId));
    }
}
