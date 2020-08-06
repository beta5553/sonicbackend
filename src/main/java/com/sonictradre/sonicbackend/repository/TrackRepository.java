package com.sonictradre.sonicbackend.repository;

import com.sonictradre.sonicbackend.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Integer> {

}
