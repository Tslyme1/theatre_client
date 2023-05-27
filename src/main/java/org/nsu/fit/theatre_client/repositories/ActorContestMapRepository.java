package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.ActorEntity;
import org.nsu.fit.theatre_client.entities.ActorcontestmapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ActorContestMapRepository extends JpaRepository<ActorcontestmapEntity, Integer> {
    void deleteByActorByActorId(ActorEntity id);
}