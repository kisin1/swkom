package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Integer> {
    // Custom query methods can be added here if needed, for example:
    // List<DocumentEntity> findByTitleContainingIgnoreCase(String title);
    // List<DocumentEntity> findByTagsContains(Integer tagId);
}