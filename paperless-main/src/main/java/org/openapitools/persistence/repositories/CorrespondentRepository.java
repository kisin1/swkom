package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.CorrespondentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrespondentRepository extends JpaRepository<CorrespondentEntity, Long> {
    // Here you can add any custom methods you might need, for example:
    // List<CorrespondentEntity> findBySlug(String slug);
    // Or, you can leave it empty if you only need the standard CRUD operations.
}
