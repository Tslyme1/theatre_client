package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.EmployeeEntity;
import org.nsu.fit.theatre_client.entities.EmployeecategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCategoryRepository extends JpaRepository<EmployeecategoryEntity, Integer> {
    List<EmployeecategoryEntity> findAllByEmployeeByEmployeeId(EmployeeEntity integer);

    void deleteByEmployeeByEmployeeId(EmployeeEntity id);
}