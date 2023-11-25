package com.recette.gestions_recettes.Services;

import com.recette.gestions_recettes.Entities.Ingredients;
import com.recette.gestions_recettes.Entities.Recette;

import java.util.Collection;
import java.util.List;

public interface RecetteService {
    public void creerRecette(String name, double duration, Collection<Ingredients> ingredients, String photo, String steps);
    public List<Recette> LireRecette();
    public Recette MiseAJourRecette(Long id, String newName, double newDuration, Collection<Ingredients> newIngredients, String newPhoto, String newSteps);
    public boolean SupprimerRecette(Long id);
}
