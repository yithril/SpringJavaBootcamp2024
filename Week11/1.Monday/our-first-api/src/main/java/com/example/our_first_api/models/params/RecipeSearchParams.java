package com.example.our_first_api.models.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeSearchParams {
    private String name;
    private String instructions;
    private Integer minCookingTime;
    private Integer maxCookingTime;
}
