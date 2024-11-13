package com.naengbu.user.entity.recipe;

import com.naengbu.user.dto.recipe.SaveRecipeDTO;
import com.naengbu.user.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "save_recipe")
@IdClass(SaveRecipeId.class)  // 복합 키 클래스 설정
public class SaveRecipeEntity {

    @Id
    @Column(name="userId", nullable = false)
    private String userId;

    @Id
    @Column(name="recipeId",nullable = false)
    private String recipeId;

    @Column(name="saveRecipesBookmark")
    private boolean saveRecipesBookmark;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "recipeId", insertable = false, updatable = false)
    private RecipeEntity recipe;

    public static SaveRecipeEntity toSaveRecipeEntity(SaveRecipeDTO saveRecipeDTO) {
        SaveRecipeEntity saveRecipeEntity = new SaveRecipeEntity();
        saveRecipeEntity.setUserId(saveRecipeDTO.getUserId());
        saveRecipeEntity.setRecipeId(saveRecipeDTO.getRecipeId());
        saveRecipeEntity.setSaveRecipesBookmark(saveRecipeDTO.isSaveRecipesBookmark());
        return saveRecipeEntity;
    }

    public static SaveRecipeEntity toUpdateSaveRecipeEntity(SaveRecipeDTO saveRecipeDTO) {
        SaveRecipeEntity saveRecipeEntity = new SaveRecipeEntity();
        saveRecipeEntity.setUserId(saveRecipeDTO.getUserId());
        saveRecipeEntity.setRecipeId(saveRecipeDTO.getRecipeId());
        saveRecipeEntity.setSaveRecipesBookmark(saveRecipeDTO.isSaveRecipesBookmark());
        return saveRecipeEntity;
    }
}
