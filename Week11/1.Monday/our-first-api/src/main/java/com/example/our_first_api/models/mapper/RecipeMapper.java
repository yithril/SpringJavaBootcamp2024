package com.example.our_first_api.models.mapper;

import com.example.our_first_api.models.Recipe;
import com.example.our_first_api.models.dto.RecipeDTO;

public class RecipeMapper {
    public static RecipeDTO toDTO(Recipe recipe){
        RecipeDTO dto = new RecipeDTO();
        dto.setId(recipe.getId());
        dto.setName(recipe.getName());
        dto.setInstructions(recipe.getInstructions());
        dto.setCookingTimeInMinutes(recipe.getCookingTimeInMinutes());

        return dto;
    }

    public static Recipe toEntity(RecipeDTO dto){
        Recipe recipe = new Recipe();

        recipe.setId(dto.getId());
        recipe.setName(dto.getName());
        recipe.setInstructions(dto.getInstructions());
        recipe.setCookingTimeInMinutes(dto.getCookingTimeInMinutes());

        return recipe;
    }
}
