package org.example.test.RestControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.test.Entities.Client;
import org.example.test.Services.IClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Client Management")
@RestController
@RequestMapping("/client/")
@AllArgsConstructor
public class ClientRestController {
    IClientService iClientService;

    @Operation(description = "Retrieve all Client")
    @GetMapping("getAll")
    public List<Client> getAllClient() {
        return iClientService.findAll();
    }

    @PostMapping("add")
    public Client addClient(@RequestBody Client client) {
        return iClientService.ajouterClient(client);
    }


    @GetMapping("getById")
    public Client getById(@RequestParam long id) {
        return iClientService.find(id);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestBody Client client) {
        iClientService.delete(client);
    }

    @PostMapping("affecterClientToMenu")
    public void affectClientAuMenu(@RequestBody String identifiant,@RequestBody String libelleMenu ){
        iClientService.affecterClientAuMenu(identifiant, libelleMenu);
    }
}
