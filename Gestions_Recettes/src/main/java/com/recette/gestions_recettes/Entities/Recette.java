package com.recette.gestions_recettes.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Recette implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom de la recette ne doit pas etre vide")
    private String name;
    private double duration;
    @NotEmpty(message = "La liste d'ingrédients ne peut pas être vide")
    @OneToMany(mappedBy = "recette")
    private Collection<Ingredients> ingredients;
    private String photo;
    @NotBlank(message = "Les étapes de la recette ne peuvent pas etre vides")
    private String steps;

}
