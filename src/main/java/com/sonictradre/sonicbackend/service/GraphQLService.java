package com.sonictradre.sonicbackend.service;

import com.sonictradre.sonicbackend.model.User;
import com.sonictradre.sonicbackend.repository.UserRepository;
import com.sonictradre.sonicbackend.service.datafetcher.AllUsersDataFetcher;
import com.sonictradre.sonicbackend.service.datafetcher.UserDataFetcher;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Stream;

@Component
public class GraphQLService {

    @Value("classpath:schema.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AllUsersDataFetcher allUsersDataFetcher;

    @Autowired
    private UserDataFetcher userDataFetcher;

    @PostConstruct
    public void loadSchema() throws IOException {
        //loadDataIntoPGsql();
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private void loadDataIntoPGsql() {
        Stream.of(
                new User(2,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")),
                new User(3,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")),
                new User(4,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020"))
        ).forEach(user -> {
            userRepository.save(user);
        }) ;
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring ->
                 typeWiring
                         .dataFetcher("allUsers", allUsersDataFetcher)
                         .dataFetcher("user", userDataFetcher)
                ).build();
    }

    public GraphQL getGraphQL(){
        return graphQL;
    }
}
