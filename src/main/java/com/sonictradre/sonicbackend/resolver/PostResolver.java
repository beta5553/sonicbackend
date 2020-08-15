package com.sonictradre.sonicbackend.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sonictradre.sonicbackend.model.Post;
import com.sonictradre.sonicbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostResolver implements GraphQLQueryResolver {

    @Autowired
    PostRepository postRepository;

    public Optional<Post> post(Integer id) {
        System.out.println("id: " + id);
        return postRepository.findById(id);
    }

    public List<Post> allPosts(){
        return postRepository.findAll();
    }

}