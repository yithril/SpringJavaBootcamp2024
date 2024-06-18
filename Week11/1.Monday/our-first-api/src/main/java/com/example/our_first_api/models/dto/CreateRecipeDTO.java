package com.example.our_first_api.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecipeDTO {
    //NotNull, Email, Past, Future, PastOrPresent, Positive, Negative, Pattern
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name can have at most 100 characters")
    private String name;

    @NotBlank(message = "Instructions are mandatory")
    private String instructions;

    @Min(value = 1, message = "Cooking time must be at least 1 minute")
    private int cookingTimeInMinutes;
}
