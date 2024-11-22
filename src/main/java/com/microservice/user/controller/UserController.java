package com.microservice.user.controller;

import com.microservice.user.dto.ResponseDto;
import com.microservice.user.dto.UserDto;
import com.microservice.user.service.IUserService;
import feign.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity.created(null).body(new ResponseDto("201", "User added successfully"));
    }

    @DeleteMapping("/remove")
    public void removeUser(@RequestBody UserDto userDto) {
        userService.removeUser(userDto);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Optional<List<UserDto>>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{userid}")
    public ResponseEntity<Optional<UserDto>> findUserByUserId(@PathVariable String userid) {
        return ResponseEntity.ok(userService.findUserByUserId(userid));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<UserDto>> findByUserName(@PathVariable String username) {
        return ResponseEntity.ok(userService.findByUserName(username));
    }

    @GetMapping("/skill/{skillname}")
    public ResponseEntity<Optional<List<UserDto>>> findUsersBySkillName(@PathVariable String skillname) {
        return ResponseEntity.ok(userService.findUsersBySkillName(skillname));
    }
}
