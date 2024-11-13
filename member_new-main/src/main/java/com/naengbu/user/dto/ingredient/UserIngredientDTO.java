package com.naengbu.user.dto.ingredient;

import com.naengbu.user.entity.ingredient.UserIngredientEntity;
import com.naengbu.user.entity.fridge.FridgeEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserIngredientDTO {
    private String u_ingredientId;
    private String fridgeId; // FridgeEntity의 fridgeId를 저장할 필드
    private String u_ingredientName;
    private String u_ingredientIconPath;
    private DateType u_ingredienDateType; // 날짜 유형을 Enum으로 사용
    private LocalDate u_ingredientDate;   // 날짜 필드는 LocalDate로 사용
    private BigDecimal u_ingredientAmount; // 수량 필드는 BigDecimal로 사용
    private String u_ingredientUnit;
    private String u_ingredientStorage;

    public enum DateType {
        EXPIRATION_DATE, PURCHASE_DATE, OTHER
    }

    public static UserIngredientDTO toUserIngredientDTO(UserIngredientEntity userIngredientEntity) {
        UserIngredientDTO userIngredientDTO = new UserIngredientDTO();
        userIngredientDTO.setU_ingredientId(userIngredientEntity.getU_ingredientId());
        if (userIngredientEntity.getFridge() != null) {
            userIngredientDTO.setFridgeId(userIngredientEntity.getFridge().getFridgeId().toString());
        }
        userIngredientDTO.setU_ingredientName(userIngredientEntity.getU_ingredientName());
        userIngredientDTO.setU_ingredientIconPath(userIngredientEntity.getU_ingredientIconPath());
        userIngredientDTO.setU_ingredienDateType(userIngredientEntity.getU_ingredienDateType());
        userIngredientDTO.setU_ingredientDate(userIngredientEntity.getU_ingredientDate());
        userIngredientDTO.setU_ingredientAmount(userIngredientEntity.getU_ingredientAmount());
        userIngredientDTO.setU_ingredientUnit(userIngredientEntity.getU_ingredientUnit());
        userIngredientDTO.setU_ingredientStorage(userIngredientEntity.getU_ingredientStorage());
        return userIngredientDTO;
    }
}

