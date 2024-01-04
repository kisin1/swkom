package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.Correspondent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CorrespondentRepository extends JpaRepository<Correspondent, Integer> {
}