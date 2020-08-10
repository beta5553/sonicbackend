package com.sonictradre.sonicbackend.service.datafetcher;

import com.sonictradre.sonicbackend.model.User;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateUserDataFetcher implements DataFetcher<List<User>> {

    @Override
    public List<User> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }
}
