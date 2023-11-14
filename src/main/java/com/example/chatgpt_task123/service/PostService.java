package com.example.chatgpt_task123.service;

import com.example.chatgpt_task123.exception.EntityNotFoundException;
import com.example.chatgpt_task123.model.Post;
import com.example.chatgpt_task123.model.User;
import com.example.chatgpt_task123.repository.PostRepository;
import com.example.chatgpt_task123.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void likePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException(Post.class, postId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(User.class, userId));

        post.getLikedByUsers().add(user);
        user.getLikedPosts().add(post);

        postRepository.save(post);
        userRepository.save(user);
    }

}

