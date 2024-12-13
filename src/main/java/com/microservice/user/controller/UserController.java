package com.microservice.user.controller;

import com.microservice.user.dto.ResponseDto;
import com.microservice.user.dto.UserDto;
import com.microservice.user.service.IUserService;
import feign.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT,
                        HttpMethod.DELETE, HttpMethod.OPTIONS)
                .build();
    }

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
    public ResponseEntity<?> findByUserName(@PathVariable String username) {
        Optional<UserDto> userOptional = userService.findByUserName(username);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User not found for username: " + username);
        }
    }
}
