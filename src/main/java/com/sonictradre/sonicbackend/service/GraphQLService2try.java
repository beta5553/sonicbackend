//package com.sonictradre.sonicbackend.service;
//
//import com.sonictradre.sonicbackend.model.Post;
//import com.sonictradre.sonicbackend.model.Track;
//import com.sonictradre.sonicbackend.model.User;
//import com.sonictradre.sonicbackend.repository.PostRepository;
//import com.sonictradre.sonicbackend.repository.TrackRepository;
//import com.sonictradre.sonicbackend.repository.UserRepository;
//import com.sonictradre.sonicbackend.service.datafetcher.*;
//import graphql.GraphQL;
//import graphql.schema.GraphQLSchema;
//import graphql.schema.idl.RuntimeWiring;
//import graphql.schema.idl.SchemaGenerator;
//import graphql.schema.idl.SchemaParser;
//import graphql.schema.idl.TypeDefinitionRegistry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import java.util.stream.Stream;
//
//@Component
//public class GraphQLService2try {
//
//    @Value("classpath:schema.graphqls")
//    Resource resource;
//
//    private GraphQL graphQL;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PostRepository postRepository;
//
//    @Autowired
//    TrackRepository trackRepository;
//
//    @Autowired
//    private AllUsersDataFetcher allUsersDataFetcher;
//
//    @Autowired
//    private UserDataFetcher userDataFetcher;
//
//    @Autowired
//    private AllPostsDataFetcher allPostsDataFetcher;
//
//    @Autowired
//    private PostDataFetcher postDataFetcher;
//
//    @Autowired
//    private AllTracksDataFetcher allTracksDataFetcher;
//
//    @Autowired
//    private TrackDataFetcher tracksDataFetcher;
//
//    @Autowired
//    private CreateUserDataFetcher createUserDataFetcher;
//
//    @PostConstruct
//    public void init() throws IOException {
//        //loadDataIntoPGsql();
//        //loadPostDataIntoPGSql();
//        //loadTrackDataIntoPGSql();
//        File schemaFile = resource.getFile();
//        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
//        RuntimeWiring wiring = buildRuntimeWiring();
//        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
//        this.graphQL = GraphQL.newGraphQL(schema).build();
//    }
//
//    private void loadDataIntoPGsql() {
//        Stream.of(
//                new User(2,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")),
//                new User(3,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")),
//                new User(4,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020"))
//        ).forEach(user -> {
//            userRepository.save(user);
//        }) ;
//    }
//
//    private void loadPostDataIntoPGSql(){
//        Stream.of(
//                new Post(2, 1, "title", "content", "tracklocation", "coverimage", new Date("01/01/2020")),
//                new Post(3, 1, "title", "content", "tracklocation", "coverimage", new Date("01/01/2020")),
//                new Post(4, 1, "title", "content", "tracklocation", "coverimage", new Date("01/01/2020"))
//        ).forEach(post -> {
//               postRepository.save(post);
//        });
//    }
//
//    private void loadTrackDataIntoPGSql(){
//        Stream.of(
//                new Track(1,2,3,5,10.50,"file location", "file format", "Description", 10, new Date("01/01/2020")),
//                new Track(2,2,3,5,10.50,"file location", "file format", "Description", 10, new Date("01/01/2020")),
//                new Track(3,2,3,5,10.50,"file location", "file format", "Description", 10, new Date("01/01/2020"))
//        ).forEach(track -> {
//            trackRepository.save(track);
//        });
//    }
//
//    private RuntimeWiring buildRuntimeWiring() {
//        return RuntimeWiring.newRuntimeWiring()
//                .type("Query", typeWiring ->
//                 typeWiring
//                         .dataFetcher("allUsers", allUsersDataFetcher)
//                         .dataFetcher("user", userDataFetcher)
//                         .dataFetcher("allPosts", allPostsDataFetcher)
//                         .dataFetcher("post", postDataFetcher)
//                         .dataFetcher("allTracks", allTracksDataFetcher)
//                         .dataFetcher("track", tracksDataFetcher)
//                ).type("Mutation", typeWiring -> typeWiring
//                        .dataFetcher("createUser", createUserDataFetcher))
//                .build();
//    }
//
//    @Bean
//    public GraphQL getGraphQL(){
//        return graphQL;
//    }
//}
