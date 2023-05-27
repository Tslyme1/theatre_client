package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.MusicianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicianRepository extends JpaRepository<MusicianEntity, Integer> {
    Optional<MusicianEntity> findByEmployeeId(Integer id);
    void deleteByEmployeeId(Integer id);
}