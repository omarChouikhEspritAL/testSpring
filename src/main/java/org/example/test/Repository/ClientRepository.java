package org.example.test.Repository;

import org.example.test.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long> {
    //Key word
    Client findByIdentifiant(String identifiant);

    //JPQL
    @Query("select c from Client c where c.identifiant=?1")
    Client findByIdentifiantJpql(String identifyant);

    //SQL
    @Query(value = "select * from client where identifiant=?1",nativeQuery = true)
    Client selectByIdentifiantSQL(String identifiant);
}
