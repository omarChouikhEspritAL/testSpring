package org.example.test.Services;

import lombok.AllArgsConstructor;
import org.example.test.Entities.Client;
import org.example.test.Entities.Menu;
import org.example.test.Repository.ClientRepository;
import org.example.test.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService{
    ClientRepository clientRepository;
    MenuRepository menuRepository;
    @Override
    public Client ajouterClient(Client client) {
        client.setDatePremiereVisite(LocalDate.now());
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client find(long id) {
        return clientRepository.findById(id).orElse(Client.builder().idClient(0).build());
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void affecterClientAuMenu(String identifiant, String libelleMenu) {
        // Chercher le client par son identifiant
        Client existingClient = clientRepository.findByIdentifiant(identifiant);
        Menu menu = menuRepository.findByLibelleMenu(libelleMenu);
        menu.getClients().add(existingClient);
        menuRepository.save(menu);
    }
}
