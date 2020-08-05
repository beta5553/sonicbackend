package com.sonictradre.sonicbackend.service.datafetcher;

import com.sonictradre.sonicbackend.model.User;
import com.sonictradre.sonicbackend.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllUsersDataFetcher implements DataFetcher <List<User>> {

    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return userRepo.findAll();
    }
}
