package com.recette.gestions_recettes.Services;

import com.recette.gestions_recettes.Entities.Ingredients;
import com.recette.gestions_recettes.Repositories.IngredientsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IngredientsServiceImpl implements IngredientsService{

    @Autowired
    private IngredientsRepository ingredientsRepository;
    @Override
    public Ingredients AjouterIngredient(Ingredients ingredient) {
            return ingredientsRepository.save(ingredient);
    }

    @Override
    public List<Ingredients> ListesAllIngredients() {
        return ingredientsRepository.findAll();
    }

    @Override
    public void MiseAourIngredient(Ingredients ingredient) {
        Ingredients ingredients = ingredientsRepository.findById(ingredient.getId()).orElse(null);
       if(ingredients!=null){
           ingredients.setIngredientName(ingredient.getIngredientName());
           ingredientsRepository.save(ingredients);
       }
    }

    @Override
    public void SupprimerIngredient(Long id) {
        Ingredients ingredients = ingredientsRepository.findById(id).orElse(null);
        if (ingredients!=null){
            ingredientsRepository.delete(ingredients);
        }
    }
}
