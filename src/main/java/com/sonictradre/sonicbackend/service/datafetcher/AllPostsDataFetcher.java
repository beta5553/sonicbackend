package com.sonictradre.sonicbackend.service.datafetcher;

import com.sonictradre.sonicbackend.model.Post;
import com.sonictradre.sonicbackend.repository.PostRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;

@Component
public class AllPostsDataFetcher
//        implements DataFetcher <List<Post>>
{

//    @Autowired
//    PostRepository postRepository;
//
//    @Override
//    public List<Post> get(DataFetchingEnvironment dataFetchingEnvironment) {
//        return postRepository.findAll();
//    }
}
