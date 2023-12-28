package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.NewTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewTagRepository extends JpaRepository<NewTagEntity, Long> {
    // Define custom query methods here if needed, for example:
    // Optional<NewTagEntity> findByName(String name);
    // List<NewTagEntity> findByColor(String color);
}
