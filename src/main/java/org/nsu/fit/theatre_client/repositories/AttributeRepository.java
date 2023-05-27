package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributeRepository extends JpaRepository<AttributeEntity, Integer> {
    Optional<AttributeEntity> findByName(String string);
}