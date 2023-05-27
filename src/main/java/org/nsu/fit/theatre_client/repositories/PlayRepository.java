package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.PlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayRepository extends JpaRepository<PlayEntity, Integer> {}