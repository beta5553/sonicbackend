package com.sonictradre.sonicbackend.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sonictradre.sonicbackend.model.Post;
import com.sonictradre.sonicbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostMutation implements GraphQLMutationResolver {

    @Autowired
    PostRepository postRepository;

    public Optional<Post> deletePost(Integer id) {
        Optional<Post> deletedPost = postRepository.findById(id);
        postRepository.deleteById(id);
        return deletedPost;
    }

    public Post createPost(){
        return null;
    }

    public Post updatePost(){
        return null;
    }
}
