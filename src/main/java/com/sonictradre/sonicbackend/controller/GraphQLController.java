//package com.sonictradre.sonicbackend.controller;
//
//import com.sonictradre.sonicbackend.model.User;
//import com.sonictradre.sonicbackend.service.GraphQLService;
//import graphql.ExecutionResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@RequestMapping("/graphqlsonic/sonic")
//@RestController
//public class GraphQLController {
//
//    @Autowired
//    GraphQLService graphQLService;
//
//    @PostMapping
//    public ResponseEntity<Object> getAllUsers(@RequestBody String query){
//
//        System.out.println("Query: " + query);
//        //query = "{ allUsers { userId }}";
//        ExecutionResult result =  graphQLService.getGraphQL().execute(query);
//        System.out.println(result.toString());
//
////        List<User> users = new ArrayList<>();
////        users.add(new User(2,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")));
////        users.add(new User(3,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")));
////        users.add(new User(4,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")));
//
//        //return users;
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//}
