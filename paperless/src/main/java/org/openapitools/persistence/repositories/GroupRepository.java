package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<UserGroup, Integer> {
}
