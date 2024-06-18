package com.example.our_first_api.services;

import com.example.our_first_api.exceptions.ResourceNotFoundException;
import com.example.our_first_api.models.Recipe;
import com.example.our_first_api.models.dto.RecipeDTO;
import com.example.our_first_api.models.mapper.RecipeMapper;
import com.example.our_first_api.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<RecipeDTO> getAllRecipes(){
        //grab all the recipes from the db
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(RecipeMapper::toDTO).toList();
    }

    public RecipeDTO getRecipeById(Long id){
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

        return RecipeMapper.toDTO(recipe);
    }

    public void deleteRecipe(Long id){
        recipeRepository.findById(id).ifPresent(recipeRepository::delete);
    }
}
