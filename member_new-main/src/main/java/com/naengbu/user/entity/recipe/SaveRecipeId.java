package com.naengbu.user.entity.recipe;

import java.io.Serializable;
import java.util.Objects;

public class SaveRecipeId implements Serializable {
    private String userId;
    private String recipeId;

    // 기본 생성자
    public SaveRecipeId() {}

    public SaveRecipeId(String userId, String recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }

    // equals()와 hashCode() 메서드 구현 (필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaveRecipeId that = (SaveRecipeId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(recipeId, that.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, recipeId);
    }
}
