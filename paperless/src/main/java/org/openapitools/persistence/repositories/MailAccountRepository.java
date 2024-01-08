package org.openapitools.persistence.repositories;

import org.openapitools.persistence.entities.MailAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailAccountRepository extends JpaRepository<MailAccount, Integer> {
}
