package com.naengbu.user.entity.ingredient;

import com.naengbu.user.dto.ingredient.RecipeIngredientDTO;
import com.naengbu.user.entity.recipe.RecipeEntity; // RecipeEntity 임포트
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "r_ingredient")
@IdClass(RecipeIngredientId.class) // 복합 키 클래스 설정
public class RecipeIngredientEntity {

    @Id
    @Column(name = "recipeId",nullable = false)
    private String recipeId;

    @Id
    @Column(name = "r_ingredientId",nullable = false)
    private String r_ingredientId;

    @Column(name = "r_ingredientIconPath")
    private String r_ingredientIconPath;

    @Column(name = "r_ingredientName")
    private String r_ingredientName;

    @Column(name = "r_ingredientAmount")
    private BigDecimal r_ingredientAmount;

    @Column(name = "r_ingredientUnit")
    private String r_ingredientUnit;

    // RecipeEntity와 다대일 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId", insertable = false, updatable = false) // 외래 키 설정
    private RecipeEntity recipe;

    // RecipeIngredientDTO -> RecipeIngredientEntity 변환 메서드
    public static RecipeIngredientEntity toRecipeIngredientEntity(RecipeIngredientDTO recipeIngredientDTO) {
        RecipeIngredientEntity recipeIngredientEntity = new RecipeIngredientEntity();
        recipeIngredientEntity.setRecipeId(recipeIngredientDTO.getRecipeId());
        recipeIngredientEntity.setR_ingredientId(recipeIngredientDTO.getR_ingredientId());
        recipeIngredientEntity.setR_ingredientIconPath(recipeIngredientDTO.getR_ingredientIconPath());
        recipeIngredientEntity.setR_ingredientName(recipeIngredientDTO.getR_ingredientName());
        recipeIngredientEntity.setR_ingredientAmount(recipeIngredientDTO.getR_ingredientAmount());
        recipeIngredientEntity.setR_ingredientUnit(recipeIngredientDTO.getR_ingredientUnit());
        return recipeIngredientEntity;
    }

    // RecipeIngredientDTO -> RecipeIngredientEntity 변환 (업데이트용) 메서드
    public static RecipeIngredientEntity toUpdateRecipeIngredientEntity(RecipeIngredientDTO recipeIngredientDTO) {
        RecipeIngredientEntity recipeIngredientEntity = new RecipeIngredientEntity();
        recipeIngredientEntity.setRecipeId(recipeIngredientDTO.getRecipeId());
        recipeIngredientEntity.setR_ingredientId(recipeIngredientDTO.getR_ingredientId());
        recipeIngredientEntity.setR_ingredientIconPath(recipeIngredientDTO.getR_ingredientIconPath());
        recipeIngredientEntity.setR_ingredientName(recipeIngredientDTO.getR_ingredientName());
        recipeIngredientEntity.setR_ingredientAmount(recipeIngredientDTO.getR_ingredientAmount());
        recipeIngredientEntity.setR_ingredientUnit(recipeIngredientDTO.getR_ingredientUnit());
        return recipeIngredientEntity;
    }
}
