package com.example.our_first_api.repositories;

import com.example.our_first_api.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    //Derived Query
    List<Recipe> findByNameContainingIgnoreCase(String name);
    List<Recipe> findByInstructionsContainingIgnoreCase(String instructions);
    List<Recipe> findByCookingTimeInMinutesBetween(int start, int end);
}
