package com.sonictradre.sonicbackend.service.datafetcher;

import com.sonictradre.sonicbackend.model.Post;
import com.sonictradre.sonicbackend.repository.PostRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostDataFetcher implements DataFetcher<Optional<Post>> {

    @Autowired
    PostRepository postRepository;

    @Override
    public Optional<Post> get(DataFetchingEnvironment dataFetchingEnvironment) {
    Integer id = dataFetchingEnvironment.getArgument("id");
    System.out.println("User id:"+ id);
    Optional<Post> post = postRepository.findById(id);
    System.out.println();

    return post;
    }
}
