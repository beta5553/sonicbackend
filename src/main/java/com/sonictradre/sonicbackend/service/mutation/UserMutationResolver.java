package com.sonictradre.sonicbackend.service.mutation;

import com.sonictradre.sonicbackend.model.User;
import com.sonictradre.sonicbackend.repository.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMutationResolver implements GraphQLMutationResolver  {

    @Autowired
    UserRepository userRepository;

    public User deleteUser(Integer id) {

        System.out.println("deleteUser resolver activated");
        User user = new User();
        user.setUserId(2);
        user.setBiography("Biography");
        user.setFirstName("Israel");
        user.setLastName("Last name");
        user.setEmail("email");

        return user;
    }

}
