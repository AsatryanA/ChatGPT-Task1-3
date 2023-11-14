package com.example.chatgpt_task123.repository;

import com.example.chatgpt_task123.model.Post;
import com.example.chatgpt_task123.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFollowers_Id(Long followerId);
    List<User> findByFollowing_Id(Long userId);
    List<Post> findLikedPostsById(Long userId);
}
