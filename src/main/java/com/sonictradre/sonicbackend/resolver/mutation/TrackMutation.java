package com.sonictradre.sonicbackend.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sonictradre.sonicbackend.model.Track;
import com.sonictradre.sonicbackend.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TrackMutation implements GraphQLMutationResolver {

    @Autowired
    TrackRepository trackRepository;

    public Track deleteTrack(Integer id) {
        Track deletedTrack = trackRepository.findById(id).get();
        trackRepository.deleteById(id);
        return deletedTrack;
    }

    public Track createTrack(){
        return null;
    }

    public Track updateTrack(){
        return null;
    }

}
