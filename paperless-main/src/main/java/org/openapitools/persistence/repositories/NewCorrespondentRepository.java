package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.NewCorrespondentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewCorrespondentRepository extends JpaRepository<NewCorrespondentEntity, Long> {
    // You can add custom methods here if needed, for example:
    // List<NewCorrespondentEntity> findByNameContainingIgnoreCase(String name);
}