package com.example.our_first_api.controllers;

import com.example.our_first_api.models.Recipe;
import com.example.our_first_api.models.dto.RecipeDTO;
import com.example.our_first_api.repositories.RecipeRepository;
import com.example.our_first_api.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Recipe")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getRecipes(){
        var recipes = recipeRepository.findAll();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id){
        return new ResponseEntity<>(recipeService.getRecipeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id){
        Optional<Recipe> recipe = recipeRepository.findById(id);

        if(recipe.isPresent()){
            recipeRepository.delete(recipe.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        Recipe createdRecipe = recipeRepository.save(recipe);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id){
        Optional<Recipe> recipeToUpdate = recipeRepository.findById(id);

        if(recipeToUpdate.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        recipeToUpdate.get().setName(recipe.getName());
        recipeToUpdate.get().setInstructions(recipe.getInstructions());
        recipeToUpdate.get().setCookingTimeInMinutes(recipe.getCookingTimeInMinutes());

        recipeRepository.save(recipeToUpdate.get());

        return new ResponseEntity<>(recipeToUpdate.get(), HttpStatus.OK);
    }
}
