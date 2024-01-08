package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.UserPermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionsRepository extends JpaRepository<UserPermissions, Integer> {
}