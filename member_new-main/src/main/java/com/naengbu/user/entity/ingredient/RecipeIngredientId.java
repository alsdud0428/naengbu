package com.naengbu.user.entity.ingredient;

import java.io.Serializable;
import java.util.Objects;

public class RecipeIngredientId implements Serializable {

    private static final long serialVersionUID = 1L;  // 직렬화 버전 ID 추가

    private String recipeId;
    private String r_ingredientId;

    // 기본 생성자
    public RecipeIngredientId() {
    }

    // 매개변수 있는 생성자
    public RecipeIngredientId(String recipeId, String r_ingredientId) {
        this.recipeId = recipeId;
        this.r_ingredientId = r_ingredientId;
    }

    // Getter와 Setter 추가
    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getR_ingredientId() {
        return r_ingredientId;
    }

    public void setR_ingredientId(String r_ingredientId) {
        this.r_ingredientId = r_ingredientId;
    }

    // hashCode와 equals는 필수로 오버라이드 해야 합니다.
    @Override
    public int hashCode() {
        return Objects.hash(recipeId, r_ingredientId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredientId that = (RecipeIngredientId) o;
        return Objects.equals(recipeId, that.recipeId) &&
                Objects.equals(r_ingredientId, that.r_ingredientId);
    }
}
