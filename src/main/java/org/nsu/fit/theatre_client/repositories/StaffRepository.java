package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {
    Optional<StaffEntity> findByEmployeeId(Integer id);
}