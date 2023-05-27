package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.EmployeeEntity;
import org.nsu.fit.theatre_client.entities.EmployeeattributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAttributeRepository extends JpaRepository<EmployeeattributeEntity, Integer> {
    List<EmployeeattributeEntity> findAllByEmployeeByEmployeeId(EmployeeEntity employeeEntity);

    void deleteByEmployeeByEmployeeId(EmployeeEntity id);
}