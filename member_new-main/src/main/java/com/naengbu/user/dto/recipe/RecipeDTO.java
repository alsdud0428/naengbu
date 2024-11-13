package com.naengbu.user.dto.recipe;

import com.naengbu.user.entity.recipe.RecipeEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecipeDTO {
    private String recipeId;
    private String recipeName;
    private String recipeState;
    private String recipeMethod;

    public static RecipeDTO toRecipeDTO(RecipeEntity recipeEntity) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setRecipeId(recipeEntity.getRecipeId());
        recipeDTO.setRecipeName(recipeEntity.getRecipeName());
        recipeDTO.setRecipeState(recipeEntity.getRecipeState());
        recipeDTO.setRecipeMethod(recipeEntity.getRecipeMethod());
        return recipeDTO;
    }
}
