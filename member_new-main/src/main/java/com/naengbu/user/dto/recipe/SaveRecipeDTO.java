package com.naengbu.user.dto.recipe;

import com.naengbu.user.entity.recipe.SaveRecipeEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaveRecipeDTO {
    private String userId;
    private String recipeId;
    private boolean saveRecipesBookmark;

    // SaveRecipeEntity를 SaveRecipeDTO로 변환하는 메서드
    public static SaveRecipeDTO toSaveRecipeDTO(SaveRecipeEntity saveRecipeEntity) {
        SaveRecipeDTO saveRecipeDTO = new SaveRecipeDTO();
        saveRecipeDTO.setRecipeId(saveRecipeEntity.getRecipeId());
        saveRecipeDTO.setUserId(saveRecipeEntity.getUserId());
        saveRecipeDTO.setSaveRecipesBookmark(saveRecipeEntity.isSaveRecipesBookmark()); // Getter 호출
        return saveRecipeDTO;
    }
}
