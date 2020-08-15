package com.sonictradre.sonicbackend.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sonictradre.sonicbackend.model.Track;
import com.sonictradre.sonicbackend.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackResolver implements GraphQLQueryResolver {

    @Autowired
    TrackRepository trackRepository;

    public Optional<Track> track(Integer id) {
        System.out.println("id: " + id);
        return trackRepository.findById(id);
    }

    public List<Track> allTracks(){
        return trackRepository.findAll();
    }

}