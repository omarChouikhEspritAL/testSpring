package org.example.test.RestControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.test.Entities.Client;
import org.example.test.Entities.Menu;
import org.example.test.Repository.ComposantRepository;
import org.example.test.Services.IMenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Menu Management")
@RestController
@RequestMapping("/menu/")
@AllArgsConstructor
public class MenuRestController {
    IMenuService iMenuService;
    ComposantRepository composantRepository;
    @Operation(description = "Retrieve all Menu")
    @GetMapping("getAll")
    public List<Menu> getAllMenu() {
        return iMenuService.findAll();
    }

    @PostMapping("add")
    public Menu addMenu(@RequestBody Menu menu) {
        return iMenuService.add(menu);
    }


    @GetMapping("getById")
    public Menu getById(@RequestParam long id) {
        return iMenuService.find(id);
    }

    @DeleteMapping("/delete")
    public void deleteMenu(@RequestBody Menu menu) {
        iMenuService.delete(menu);
    }

    @PostMapping("add")
    public Menu addMenu(@RequestBody Menu menu) {
        return iMenuService.ajoutComposantsEtMiseAJourPrixTotalMenu(composantRepository.findAll(),menu);
    }

}
