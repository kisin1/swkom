package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.PaperlessTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessTaskRepository extends JpaRepository<PaperlessTask, Integer> {
}
