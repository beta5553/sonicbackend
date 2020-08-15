package com.sonictradre.sonicbackend.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sonictradre.sonicbackend.model.User;
import com.sonictradre.sonicbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserResolver implements GraphQLQueryResolver {

    @Autowired
    UserRepository userRepository;

    public Optional<User> user(Integer id) {
        System.out.println("id: " + id);
        return userRepository.findById(id);
    }

    public List<User> allUsers(){
        return userRepository.findAll();
    }

}