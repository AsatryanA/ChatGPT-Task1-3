package com.example.chatgpt_task123.controller;

import com.example.chatgpt_task123.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/follow/{followerId}")
    public ResponseEntity<Void> followUser(@PathVariable Long userId, @PathVariable Long followerId) {
        userService.followUser(userId, followerId);
        return ResponseEntity.ok().build();
    }

}
