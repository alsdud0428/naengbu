package com.naengbu.user.entity.ingredient;

import java.io.Serializable;
import java.util.Objects;

public class UserIngredientId implements Serializable {

    private String u_ingredientId;
    private String fridgeId;
    private String userId;  // 추가된 userId 필드

    // 기본 생성자
    public UserIngredientId() {
    }

    // 매개변수 있는 생성자
    public UserIngredientId(String u_ingredientId, String fridgeId, String userId) {
        this.u_ingredientId = u_ingredientId;
        this.fridgeId = fridgeId;
        this.userId = userId;  // userId 추가
    }

    // equals 메서드 오버라이드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIngredientId that = (UserIngredientId) o;
        return Objects.equals(u_ingredientId, that.u_ingredientId) &&
                Objects.equals(fridgeId, that.fridgeId) &&
                Objects.equals(userId, that.userId);  // userId 비교 추가
    }

    // hashCode 메서드 오버라이드
    @Override
    public int hashCode() {
        return Objects.hash(u_ingredientId, fridgeId, userId);  // userId 추가
    }
}
