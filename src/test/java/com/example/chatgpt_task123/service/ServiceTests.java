package com.example.chatgpt_task123.service;

import com.example.chatgpt_task123.model.Post;
import com.example.chatgpt_task123.model.User;
import com.example.chatgpt_task123.repository.PostRepository;
import com.example.chatgpt_task123.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)

public class ServiceTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private UserService userService;

    @InjectMocks
    private PostService postService;

    @Test
    public void testFollowUser() {
        Long userId = 1L;
        Long followerId = 2L;

        User user = new User();
        User follower = new User();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findById(followerId)).thenReturn(Optional.of(follower));

        userService.followUser(userId, followerId);

        assertThat(user.getFollowers()).contains(follower);
        assertThat(follower.getFollowing()).contains(user);

        verify(userRepository, times(1)).save(user);
        verify(userRepository, times(1)).save(follower);
    }

    @Test
    public void testLikePost() {
        Long postId = 1L;
        Long userId = 2L;

        Post post = new Post();
        User user = new User();

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        postService.likePost(postId, userId);

        assertThat(post.getLikedByUsers()).contains(user);
        assertThat(user.getLikedPosts()).contains(post);

        verify(postRepository, times(1)).save(post);
        verify(userRepository, times(1)).save(user);
    }

}
