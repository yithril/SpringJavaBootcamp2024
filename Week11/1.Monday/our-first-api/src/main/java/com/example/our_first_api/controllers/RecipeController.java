package com.example.our_first_api.controllers;

import com.example.our_first_api.models.Recipe;
import com.example.our_first_api.models.dto.CreateRecipeDTO;
import com.example.our_first_api.models.dto.RecipeDTO;
import com.example.our_first_api.models.dto.UpdateRecipeDTO;
import com.example.our_first_api.models.params.RecipeSearchParams;
import com.example.our_first_api.repositories.RecipeRepository;
import com.example.our_first_api.services.RecipeService;
import jakarta.validation.Valid;
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
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getRecipes(){
        var recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id){
        return new ResponseEntity<>(recipeService.getRecipeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@Valid @RequestBody CreateRecipeDTO dto){
        var recipe = recipeService.createRecipe(dto);

        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@Valid @RequestBody UpdateRecipeDTO dto, @PathVariable Long id){
       var recipe = recipeService.updateRecipe(dto, id);

       return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecipeDTO>> searchRecipes(@ModelAttribute RecipeSearchParams searchParams){
        var recipeDTOs = recipeService.searchRecipes(searchParams);

        return new ResponseEntity<>(recipeDTOs, HttpStatus.OK);
    }
}
