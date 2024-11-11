package com.microservice.user.controller;

import com.microservice.user.dto.UserDto;
import com.microservice.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
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
    public Optional<List<UserDto>> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}")
    public Optional<UserDto> findUserByUserId(@PathVariable String userid) {
        return userService.findUserByUserId(userid);
    }

    @GetMapping("/username/{username}")
    public Optional<UserDto> findByUserName(@PathVariable String username) {
        return userService.findByUserName(username);
    }

    @GetMapping("/skill/{skillname}")
    public Optional<List<UserDto>> findUsersBySkillName(@PathVariable String skillname) {
        return userService.findUsersBySkillName(skillname);
    }
}
