package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.NewDocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewDocumentTypeRepository extends JpaRepository<NewDocumentTypeEntity, Long> {
    // Define custom query methods here if needed, for example:
    // Optional<NewDocumentTypeEntity> findByName(String name);
}
