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

    @PostMapping("/")
    public ResponseEntity<ResponseDto> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> removeUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.removeUser(id));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{userid}")
    public ResponseEntity<Optional<UserDto>> findUserByUserId(@PathVariable Long userid) {
        return ResponseEntity.ok(userService.findUserByUserId(userid));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<UserDto>> findByUserName(@PathVariable String username) {
        return ResponseEntity.ok(userService.findByUserName(username));
    }
}
