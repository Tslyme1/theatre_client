package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.EmployeeprofileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeprofileEntity, Integer> {
    List<EmployeeprofileEntity> findByFirstNameAndLastNameAndPatronymicName(String firstName, String lastName, String patronymicName);
}