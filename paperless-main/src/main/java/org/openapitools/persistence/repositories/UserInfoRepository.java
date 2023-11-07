package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
    // Here you can add custom methods, such as finding a user by username:
    // Optional<UserInfoEntity> findByUsername(String username);
}
