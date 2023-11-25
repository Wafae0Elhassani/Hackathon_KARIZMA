package com.recette.gestions_recettes.Services;

import com.recette.gestions_recettes.Entities.Ingredients;
import com.recette.gestions_recettes.Entities.Recette;
import com.recette.gestions_recettes.Repositories.RecetteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class RecetteServiceImpl implements RecetteService{

    @Autowired
    private RecetteRepository recetteRepository;
    @Override
    public void creerRecette(String name, double duration, Collection<Ingredients> ingredients, String photo, String steps) {
        Recette recette = new Recette();
        recette.setName(name);
        recette.setDuration(duration);
        recette.setIngredients(ingredients);
        recette.setPhoto(photo);
        recette.setSteps(steps);
        recetteRepository.save(recette);
    }

    @Override
    public List<Recette> LireRecette() {
        return recetteRepository.findAll();
    }

    @Override
    public Recette MiseAJourRecette(Long id, String newName, double newDuration, Collection<Ingredients> newIngredients, String newPhoto, String newSteps) {

        Recette recette = recetteRepository.findById(id).orElse(null);

        if (recette != null) {
            recette.setName(newName);
            recette.setDuration(newDuration);
            recette.setIngredients(newIngredients);
            recette.setPhoto(newPhoto);
            recette.setSteps(newSteps);
            recetteRepository.save(recette);
        }
        return recette;
    }


    @Override
    public boolean SupprimerRecette(Long id) {
        Recette recette = recetteRepository.findById(id).orElse(null);
        if (recette != null) {
            recetteRepository.delete(recette);
            return true;
        }

        return false;
    }
}
