package com.naengbu.user.dto.ingredient;

import com.naengbu.user.entity.ingredient.RecipeIngredientEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecipeIngredientDTO {
    private String recipeId;
    private String r_ingredientId;
    private String r_ingredientIconPath;
    private String r_ingredientName;
    private BigDecimal r_ingredientAmount;
    private String r_ingredientUnit;

    // RecipeIngredientEntity -> RecipeIngredientDTO 변환 메서드
    public static RecipeIngredientDTO toRecipeIngredientDTO(RecipeIngredientEntity recipeIngredientEntity) {
        RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO();
        recipeIngredientDTO.setRecipeId(recipeIngredientEntity.getRecipeId());
        recipeIngredientDTO.setR_ingredientId(recipeIngredientEntity.getR_ingredientId());
        recipeIngredientDTO.setR_ingredientIconPath(recipeIngredientEntity.getR_ingredientIconPath());
        recipeIngredientDTO.setR_ingredientName(recipeIngredientEntity.getR_ingredientName());
        recipeIngredientDTO.setR_ingredientAmount(recipeIngredientEntity.getR_ingredientAmount());
        recipeIngredientDTO.setR_ingredientUnit(recipeIngredientEntity.getR_ingredientUnit());
        return recipeIngredientDTO;
    }
}
