package com.sonictradre.sonicbackend.service.datafetcher;

import com.sonictradre.sonicbackend.model.Post;
import com.sonictradre.sonicbackend.model.Track;
import com.sonictradre.sonicbackend.repository.PostRepository;
import com.sonictradre.sonicbackend.repository.TrackRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TrackDataFetcher {

    @Autowired
    TrackRepository trackRepository;

    public DataFetcher getAllTracks() {
        return dataFetchingEnvironment -> trackRepository.findAll();
    }


    public DataFetcher getTrack(){
        //<ptional<Track> track = trackRepository.findById(2);
        return dataFetchingEnvironment -> trackRepository.findById(dataFetchingEnvironment.getArgument("id"));
    }
}
