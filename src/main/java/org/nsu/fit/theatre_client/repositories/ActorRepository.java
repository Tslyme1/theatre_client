package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
    Optional<ActorEntity> findByEmployeeId(Integer id);
    void deleteByEmployeeId(Integer id);
}