package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.DirectorEntity;
import org.nsu.fit.theatre_client.entities.PlaydirectormapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayDirectorMapRepository extends JpaRepository<PlaydirectormapEntity, Integer> {
    void deleteByDirectorByDirectorId(DirectorEntity id);
}