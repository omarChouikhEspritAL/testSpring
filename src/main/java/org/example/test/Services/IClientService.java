package org.example.test.Services;

import org.example.test.Entities.Client;

import java.util.List;

public interface IClientService {
    Client ajouterClient(Client client);
    Client update (Client client);
    List<Client> findAll();
    Client find(long id);
    void  delete(Client client);
    void affecterClientAuMenu(String identifiant, String libelleMenu);
}
