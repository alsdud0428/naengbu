package com.naengbu.user.entity.recipe;

import com.naengbu.user.dto.recipe.RecipeDTO;
import com.naengbu.user.entity.ingredient.RecipeIngredientEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "recipe")
public class RecipeEntity {
    @Id
    @Column(name = "recipeId",nullable = false)
    private String recipeId;

    @Column(name = "recipeName")
    private String recipeName;

    @Column(name = "recipeState")
    private String recipeState;

    @Column(name = "recipeMethod")
    private String recipeMethod;

    // RecipeIngredientEntity와의 일대다 관계 정의
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RecipeIngredientEntity> recipeIngredients;

    // SaveRecipeEntity와의 일대다 관계 정의
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SaveRecipeEntity> saveRecipes;

    // DTO를 Entity로 변환하는 메서드
    public static RecipeEntity toRecipeEntity(RecipeDTO recipeDTO) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setRecipeId(recipeDTO.getRecipeId());
        recipeEntity.setRecipeName(recipeDTO.getRecipeName());
        recipeEntity.setRecipeState(recipeDTO.getRecipeState());
        recipeEntity.setRecipeMethod(recipeDTO.getRecipeMethod());
        return recipeEntity;
    }

    public static RecipeEntity toUpdateRecipeEntity(RecipeDTO recipeDTO) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setRecipeId(recipeDTO.getRecipeId());
        recipeEntity.setRecipeName(recipeDTO.getRecipeName());
        recipeEntity.setRecipeState(recipeDTO.getRecipeState());
        recipeEntity.setRecipeMethod(recipeDTO.getRecipeMethod());
        return recipeEntity;
    }
}
