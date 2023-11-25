package com.recette.gestions_recettes.Controllers;

import com.recette.gestions_recettes.Entities.Ingredients;
import com.recette.gestions_recettes.Entities.Recette;
import com.recette.gestions_recettes.Services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/recette")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @GetMapping("/")
    public String afficher(Model model){
        return "CreateRecette";
    }

    @PostMapping("/create")
    public String createRecette(
            @RequestParam String name,
            @RequestParam double duration,
            @RequestParam Collection<Ingredients> ingredients,
            @RequestParam String photo,
            @RequestParam String steps) {
        recetteService.creerRecette(name, duration, ingredients, photo, steps);
        return "Recettes";
    }

    @GetMapping("/Recettes")
    public String ListRecettes(Model model) {
        List<Recette> recettes = recetteService.LireRecette();
        model.addAttribute("Recettes", recettes);
        return "recette/Recettes";
    }

    @PostMapping("/recette/MiseAjour")
    public String miseAJourRecette(
            @RequestParam Long id,
            @RequestParam String newName,
            @RequestParam double newDuration,
            @RequestParam Collection<Ingredients> newIngredients,
            @RequestParam String newPhoto,
            @RequestParam String newSteps,
            Model model) {
        Recette newRecette = recetteService.MiseAJourRecette(id, newName, newDuration, newIngredients, newPhoto, newSteps);
        if (newRecette == null) {
            model.addAttribute("Error", "Cette Recette n'exite pas");
            return "404Page";
        }
        return "redirect:/recette/Recettes";
    }

    @PostMapping("/recette/delete")
    public String supprimerRecette(@RequestParam Long id, Model model) {
        boolean recetteValue = recetteService.SupprimerRecette(id);
        if (!recetteValue) {
            model.addAttribute("Error", "Cette Recette n'exite pas");
            return "404Page";
        }
        return "redirect:/recette/Recettes";
    }
}

