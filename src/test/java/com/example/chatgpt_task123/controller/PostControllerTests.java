package com.example.chatgpt_task123.controller;

import com.example.chatgpt_task123.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
public class PostControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    public void testLikePost() throws Exception {
        Long postId = 1L;
        Long userId = 2L;

        mockMvc.perform(post("/api/posts/{postId}/like/{userId}", postId, userId))
                .andExpect(status().isOk());

        verify(postService, times(1)).likePost(postId, userId);
    }

}
