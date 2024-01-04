package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.SavedViewFilterRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedViewFilterRuleRepository extends JpaRepository<SavedViewFilterRule, Integer> {
}
