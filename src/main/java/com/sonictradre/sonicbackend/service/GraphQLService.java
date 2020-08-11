package com.sonictradre.sonicbackend.service;

import com.sonictradre.sonicbackend.dataloader.DataLoader;
import com.sonictradre.sonicbackend.repository.PostRepository;
import com.sonictradre.sonicbackend.repository.TrackRepository;
import com.sonictradre.sonicbackend.repository.UserRepository;
import com.sonictradre.sonicbackend.service.datafetcher.*;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class GraphQLService {

    @Value("classpath:schema.graphqls")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    private UserDataFetcher userDataFetcher;

    @Autowired
    private AllPostsDataFetcher allPostsDataFetcher;

    @Autowired
    private PostDataFetcher postDataFetcher;

    @Autowired
    private TrackDataFetcher trackDataFetcher;

    @Autowired
    private CreateUserDataFetcher createUserDataFetcher;

    @Autowired
    private DataLoader dataLoader;

    @PostConstruct
    public void loadSchema() throws IOException {
        //dataLoader.loadUserData();
        //dataLoader.loadPostData();
        //dataLoader.loadTrackData();
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring ->
                 typeWiring
                         .dataFetcher("allUsers", userDataFetcher.getAllUsers())
                         .dataFetcher("user", userDataFetcher.getUser())
                         .dataFetcher("allPosts", postDataFetcher.getAllPost())
                         .dataFetcher("post", postDataFetcher.getPost())
                         .dataFetcher("allTracks", trackDataFetcher.getAllTracks())
                         .dataFetcher("track", trackDataFetcher.getTrack())
                ).type("Mutation", typeWiring -> typeWiring
                        .dataFetcher("createUser", createUserDataFetcher))
                .build();
    }

    @Bean
    public GraphQL getGraphQL(){
        return graphQL;
    }
}
