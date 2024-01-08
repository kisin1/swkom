package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.ProcessedMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedMailRepository extends JpaRepository<ProcessedMail, Integer> {
}
