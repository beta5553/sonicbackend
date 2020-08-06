package com.sonictradre.sonicbackend.repository;

import com.sonictradre.sonicbackend.model.Post;
import com.sonictradre.sonicbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
