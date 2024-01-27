package org.example.test.Services;

import lombok.AllArgsConstructor;
import org.example.test.Entities.Composant;
import org.example.test.Repository.ComposantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //Définir que c'est un bean Spring
@AllArgsConstructor
public class ComposantService implements IComposantService{
    ComposantRepository composantRepository;
    @Override
    public Composant add(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public Composant update(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public List<Composant> findAll() {
        return composantRepository.findAll();
    }

    @Override
    public Composant find(long id) {
        return composantRepository.findById(id).orElse(Composant.builder().idCompsant(0).build());
    }

    @Override
    public void delete(Composant composant) {
        composantRepository.delete(composant);
    }

}
