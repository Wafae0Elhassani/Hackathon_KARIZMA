package com.recette.gestions_recettes.Controllers;

import com.recette.gestions_recettes.Entities.Ingredients;
import com.recette.gestions_recettes.Services.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @PostMapping("/ajouter")
    public void AjouterIngredient(@RequestBody Ingredients ingredient) {
        Ingredients savedIngredient = ingredientsService.AjouterIngredient(ingredient);
    }

    @GetMapping("/listes")
    public void listesIngredients() {
        List<Ingredients> allIngredients = ingredientsService.ListesAllIngredients();
    }

    @PutMapping("/MiseAJour")
    public void updateIngredient(@RequestBody Ingredients ingredient) {
        ingredientsService.MiseAourIngredient(ingredient);
    }
    @DeleteMapping("/supprimer/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientsService.SupprimerIngredient(id);
    }

}
