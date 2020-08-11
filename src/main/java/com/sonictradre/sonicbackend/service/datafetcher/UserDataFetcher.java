package com.sonictradre.sonicbackend.service.datafetcher;

import com.sonictradre.sonicbackend.model.User;
import com.sonictradre.sonicbackend.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Component
public class UserDataFetcher {

    @Autowired
    UserRepository userRepository;

    public DataFetcher<List<User>> getAllUsers(){
        return dataFetchingEnvironment -> userRepository.findAll();
    }

    public DataFetcher getUser() {
        return dataFetchingEnvironment -> userRepository.findById(dataFetchingEnvironment.getArgument("id"));
    }

}
