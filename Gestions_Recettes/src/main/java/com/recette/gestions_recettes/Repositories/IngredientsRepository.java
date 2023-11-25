package com.recette.gestions_recettes.Repositories;

import com.recette.gestions_recettes.Entities.Ingredients;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients,Long> {
}
