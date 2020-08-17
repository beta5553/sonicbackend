package com.sonictradre.sonicbackend.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sonictradre.sonicbackend.model.User;
import com.sonictradre.sonicbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    UserRepository userRepository;

    public Optional<User> deleteUser(Integer id){
        Optional<User> deletedUser = userRepository.findById(id);
        userRepository.deleteById(id);
        return deletedUser;
    }

    /**
     * createUser mutation method.
     * @param firstName
     * @param lastName
     * @param userName
     * @param email
     * @param password
     * @param biography
     * @return User
     */
    public User createUser(String firstName,
                           String lastName,
                           String userName,
                           String email,
                           String password,
                           String biography) {

        LocalDate createdDate = LocalDate.now();
        //TODO: Verify email and user name are unique before saving.

        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setUserName(userName);
        newUser.setEmail(email);
        newUser.setBiography(biography);
        newUser.setPassword(password);
        newUser.setCreatedDate(createdDate);

        userRepository.save(newUser);
        return newUser;
    }

    /**
     * createUser mutation method.
     * @param firstName
     * @param lastName
     * @param userName
     * @param email
     * @param password
     * @param biography
     * @return User
     */
    public User updateUser(Integer id,
                           String firstName,
                           String lastName,
                           String userName,
                           String email,
                           String password,
                           String biography) {

        LocalDate lastModifiedDate = LocalDate.now();
        //TODO: Verify email and user name are unique before saving.

        User editUser = userRepository.findById(id).get();
        editUser.setFirstName(firstName);
        editUser.setLastName(lastName);
        editUser.setUserName(userName);
        editUser.setEmail(email);
        editUser.setBiography(biography);
        editUser.setPassword(password);
        editUser.setCreatedDate(lastModifiedDate);

        userRepository.save(editUser);
        return editUser;
    }
}
