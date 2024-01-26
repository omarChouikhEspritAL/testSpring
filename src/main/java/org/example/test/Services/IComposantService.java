package org.example.test.Services;

import org.example.test.Entities.Composant;

import java.util.List;

public interface IComposantService {
    Composant add(Composant composant);
    Composant update (Composant composant);
    List<Composant> findAll();
    Composant find(long id);
    void  delete(Composant composant);
}
