package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.MusicianEntity;
import org.nsu.fit.theatre_client.entities.PlaymusicianmapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayMusicianMapRepository extends JpaRepository<PlaymusicianmapEntity, Integer> {
    void deleteAllByMusicianByMusicianId(MusicianEntity id);
}