package com.sonictradre.sonicbackend.dataloader;

import com.sonictradre.sonicbackend.model.Post;
import com.sonictradre.sonicbackend.model.Track;
import com.sonictradre.sonicbackend.model.User;
import com.sonictradre.sonicbackend.repository.PostRepository;
import com.sonictradre.sonicbackend.repository.TrackRepository;
import com.sonictradre.sonicbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Stream;

@Component
public class DataLoader {

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public void loadUserData(){
        Stream.of(
                new User(2,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")),
                new User(3,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020")),
                new User(4,"userName","firstName","lastName","bio","pwd","email", new Date("01/01/2020"))
        ).forEach(user -> {
            userRepository.save(user);
        }) ;
    }

    public void loadTrackData(){
        Stream.of(
                new Track(1,2,3,5,10.50,"file location", "file format", "Description", 10, new Date("01/01/2020")),
                new Track(2,2,3,5,10.50,"file location", "file format", "Description", 10, new Date("01/01/2020")),
                new Track(3,2,3,5,10.50,"file location", "file format", "Description", 10, new Date("01/01/2020"))
        ).forEach(track -> {
            trackRepository.save(track);
        });
    }

    public void loadPostData(){
        Stream.of(
                new Post(2, 1, "title", "content", "tracklocation", "coverimage", new Date("01/01/2020")),
                new Post(3, 1, "title", "content", "tracklocation", "coverimage", new Date("01/01/2020")),
                new Post(4, 1, "title", "content", "tracklocation", "coverimage", new Date("01/01/2020"))
        ).forEach(post -> {
            postRepository.save(post);
        });
    }

    public void anotherDataLoader() {
        //some code here....
    }

    public void anotherDataLoader() {
        //some code here....
    }

}
