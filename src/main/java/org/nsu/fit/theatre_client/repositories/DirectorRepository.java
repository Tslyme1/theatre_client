package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DirectorRepository extends JpaRepository<DirectorEntity, Integer> {}