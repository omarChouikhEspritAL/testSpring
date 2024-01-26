package org.example.test.Services;

import lombok.AllArgsConstructor;
import org.example.test.Entities.Client;
import org.example.test.Entities.Menu;
import org.example.test.Repository.ClientRepository;
import org.example.test.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService{
    ClientRepository clientRepository;
    MenuRepository menuRepository;
    @Override
    public Client add(Client client) {
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

    public void affecterClientAuMenu(String identifiant, String libelleMenu) {
        // Chercher le client par son identifiant
        Client existingClient = clientRepository.findByIdentifiant(identifiant);
        if (existingClient.isPresent()) {
            // Si le client existe, chercher le menu par son libellé
            Menu existingMenu = menuRepository.findByLibelleMenu(libelleMenu);
            if (existingMenu.isPresent()) {
                // Si le menu existe, ajouter le client à sa liste de clients
                Menu updatedMenu = existingMenu.get();
                updatedMenu.getClients().add(existingClient.get());
                // Enregistrer le menu modifié dans la base de données
                menuRepository.save(updatedMenu);
            } else {
                // Sinon, lancer une exception
                throw new RuntimeException("Menu introuvable");
            }
        } else {
            // Sinon, lancer une exception
            throw new RuntimeException("Client introuvable");
        }
    }
}
