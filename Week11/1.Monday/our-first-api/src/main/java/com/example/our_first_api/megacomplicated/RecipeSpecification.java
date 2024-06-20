package com.example.our_first_api.megacomplicated;

import com.example.our_first_api.models.Recipe;
import org.springframework.data.jpa.domain.Specification;

public class RecipeSpecification {
    public static Specification<Recipe> instructionsContains(String instructions){
        return (root, query, criteriaBuilder) -> {
            if(instructions == null || instructions.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("instructions"), "%" + instructions + "%");
        };
    }
    public static Specification<Recipe> nameContains(String name){
        return (root, query, criteriaBuilder) -> {
           if(name == null || name.isEmpty()){
               return criteriaBuilder.conjunction();
           }
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }
    public static Specification<Recipe> cookingTimeBetween(Integer start, Integer end) {
        return (root, query, criteriaBuilder) -> {
            if (start == null && end == null) {
                return criteriaBuilder.conjunction();
            }
            if (start == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("cookingTimeInMinutes"), end);
            }
            if (end == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("cookingTimeInMinutes"), start);
            }
            return criteriaBuilder.between(root.get("cookingTimeInMinutes"), start, end);
        };
    }
}
