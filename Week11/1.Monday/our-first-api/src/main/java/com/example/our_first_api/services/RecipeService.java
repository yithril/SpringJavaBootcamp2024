package com.example.our_first_api.services;

import com.example.our_first_api.exceptions.ResourceNotFoundException;
import com.example.our_first_api.megacomplicated.RecipeSpecification;
import com.example.our_first_api.models.Recipe;
import com.example.our_first_api.models.dto.CreateRecipeDTO;
import com.example.our_first_api.models.dto.RecipeDTO;
import com.example.our_first_api.models.dto.UpdateRecipeDTO;
import com.example.our_first_api.models.mapper.RecipeMapper;
import com.example.our_first_api.models.params.RecipeSearchParams;
import com.example.our_first_api.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

        recipeRepository.delete(recipe);
    }

    public RecipeDTO createRecipe(CreateRecipeDTO dto){
        Recipe recipe = RecipeMapper.toEntity(dto);
        Recipe createdRecipe = recipeRepository.save(recipe);
        return RecipeMapper.toDTO(createdRecipe);
    }

    public RecipeDTO updateRecipe(UpdateRecipeDTO dto, Long id){
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

        recipe.setName(dto.getName());
        recipe.setInstructions(dto.getInstructions());
        recipe.setCookingTimeInMinutes(dto.getCookingTimeInMinutes());

        Recipe updatedRecipe = recipeRepository.save(recipe);

        return RecipeMapper.toDTO(updatedRecipe);
    }

    public List<RecipeDTO> searchRecipes(RecipeSearchParams searchParams){
        List<Recipe> recipes = new ArrayList<>();
        if(searchParams.getName() == null && searchParams.getInstructions() == null
                && searchParams.getMinCookingTime() == null && searchParams.getMaxCookingTime() == null){
            recipes = recipeRepository.findAll();
        }
        else if(searchParams.getMinCookingTime() != null && searchParams.getMaxCookingTime() != null){
            recipes = recipeRepository.findByCookingTimeInMinutesBetween(searchParams.getMinCookingTime(),
                                                                         searchParams.getMaxCookingTime());
        }
        else if(searchParams.getName() != null){
            recipes = recipeRepository.findByNameContainingIgnoreCase(searchParams.getName());
        }
        else {
            recipes = recipeRepository.findByInstructionsContainingIgnoreCase(searchParams.getInstructions());
        }

        return recipes.stream().map(RecipeMapper::toDTO).toList();
    }
    //MEGA HARD STUFF
    /*
        public List<RecipeDTO> searchRecipes(RecipeSearchParams params) {
        Specification<Recipe> spec = Specification.where(RecipeSpecification.instructionsContains(params.getInstructions()))
                .and(RecipeSpecification.nameContains(params.getName()))
                .and(RecipeSpecification.cookingTimeBetween(params.getMinCookingTime(), params.getMaxCookingTime()));
        List<Recipe> recipes = recipeRepository.findAll(spec);
        return recipes.stream()
                .map(RecipeMapper::toDTO)
                .collect(Collectors.toList());
    }
     */
}
