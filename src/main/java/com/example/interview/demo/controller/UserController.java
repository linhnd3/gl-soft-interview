package com.example.interview.demo.controller;

import com.example.interview.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cooper (linh.nguyenduy@navercorp.com)
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{numUser}")
    public String getUser(@PathVariable int numUser) {
        return userService.getUser(numUser);
    }

    @PostMapping("/{numUser}")
    public ResponseEntity<Void> updateUser(@PathVariable int numUser) {
        userService.updateUser(numUser);
        return ResponseEntity.ok().build();
    }
}
