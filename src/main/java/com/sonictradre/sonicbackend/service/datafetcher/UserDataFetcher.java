package com.sonictradre.sonicbackend.service.datafetcher;

import com.sonictradre.sonicbackend.model.User;
import com.sonictradre.sonicbackend.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDataFetcher implements DataFetcher<Optional<User>> {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Integer id = dataFetchingEnvironment.getArgument("id");
        System.out.println("User id:"+ id);
        Optional<User> user = userRepository.findById(id);
        System.out.println();

        return user;
    }
}
