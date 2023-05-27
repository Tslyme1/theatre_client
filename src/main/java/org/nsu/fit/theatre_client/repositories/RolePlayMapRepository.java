package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.RoleplaymapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RolePlayMapRepository extends JpaRepository<RoleplaymapEntity, Integer> {}