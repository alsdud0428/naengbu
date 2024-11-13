package com.naengbu.user.entity.fridge;

import java.io.Serializable;
import java.util.Objects;

public class FridgeId implements Serializable {

    private String fridgeId;
    private String userId;

    // 기본 생성자
    public FridgeId() {}

    public FridgeId(String fridgeId, String userId) {
        this.fridgeId = fridgeId;
        this.userId = userId;
    }

    // equals() 메서드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FridgeId fridgeId1 = (FridgeId) o;
        return Objects.equals(fridgeId, fridgeId1.fridgeId) &&
                Objects.equals(userId, fridgeId1.userId);
    }

    // hashCode() 메서드
    @Override
    public int hashCode() {
        return Objects.hash(fridgeId, userId);
    }

    // Getter 및 Setter (옵션, 필요에 따라 추가)
    public String getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(String fridgeId) {
        this.fridgeId = fridgeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
