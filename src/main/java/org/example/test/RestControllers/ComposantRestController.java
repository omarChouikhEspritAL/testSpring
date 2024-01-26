package org.example.test.RestControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.test.Entities.Composant;
import org.example.test.Services.IComposantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Composant Management")
@RestController
@RequestMapping("/composant/")
@AllArgsConstructor
public class ComposantRestController {
    IComposantService iComposantService;
    @Operation(description = "Retrieve all Composant")
    @GetMapping("getAll")
    public List<Composant> getAllComposant() {
        return iComposantService.findAll();
    }

    @PostMapping("add")
    public Composant addComposant(@RequestBody Composant composant) {
        return iComposantService.add(composant);
    }


    @GetMapping("getById")
    public Composant getById(@RequestParam long id) {
        return iComposantService.find(id);
    }

    @DeleteMapping("/delete")
    public void deleteComposant(@RequestBody Composant composant) {
        iComposantService.delete(composant);
    }

}
