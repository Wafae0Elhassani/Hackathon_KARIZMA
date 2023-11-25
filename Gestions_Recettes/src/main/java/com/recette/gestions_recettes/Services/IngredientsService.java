package com.recette.gestions_recettes.Services;

import com.recette.gestions_recettes.Entities.Ingredients;

import java.util.List;

public interface IngredientsService {
    Ingredients AjouterIngredient(Ingredients ingredient);
    List<Ingredients> ListesAllIngredients();
    void MiseAourIngredient(Ingredients ingredient);
    void SupprimerIngredient(Long id);
}
