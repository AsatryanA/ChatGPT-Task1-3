package com.example.chatgpt_task123.controller;

import com.example.chatgpt_task123.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testFollowUser() throws Exception {
        Long userId = 1L;
        Long followerId = 2L;

        mockMvc.perform(post("/api/users/{userId}/follow/{followerId}", userId, followerId))
                .andExpect(status().isOk());

        verify(userService, times(1)).followUser(userId, followerId);
    }

}
