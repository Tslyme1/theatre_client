package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.ActorEntity;
import org.nsu.fit.theatre_client.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    List<RoleEntity> findAllByActorByActorId(ActorEntity id);
    List<RoleEntity> findAllByActorByBackup(ActorEntity id);
}