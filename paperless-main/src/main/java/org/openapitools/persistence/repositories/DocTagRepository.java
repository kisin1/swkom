package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.DocTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocTagRepository extends JpaRepository<DocTagEntity, Long> {
    // You can add custom methods if needed, e.g.:
    // List<DocTagEntity> findBySlug(String slug);
}