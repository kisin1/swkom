package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.DocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentTypeEntity, Long> {
    // Custom query methods can be added here if needed, for example:
    // Optional<DocumentTypeEntity> findBySlug(String slug);
    // List<DocumentTypeEntity> findByNameContainingIgnoreCase(String name);
}
