package org.example.test.Repository;

import org.example.test.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByIdentifiant(String identifiant);
}
