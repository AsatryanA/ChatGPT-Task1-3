package com.example.chatgpt_task123.service;

import com.example.chatgpt_task123.exception.EntityNotFoundException;
import com.example.chatgpt_task123.model.User;
import com.example.chatgpt_task123.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;
        public void followUser(Long userId, Long followerId) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException(User.class, userId));
            User follower = userRepository.findById(followerId)
                    .orElseThrow(() -> new EntityNotFoundException(User.class, followerId));
            user.getFollowers().add(follower);
            follower.getFollowing().add(user);

            userRepository.save(user);
            userRepository.save(follower);
        }
}
