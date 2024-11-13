package com.naengbu.user.entity.ingredient;

import com.naengbu.user.dto.ingredient.UserIngredientDTO;
import com.naengbu.user.entity.fridge.FridgeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "u_ingredient")
@IdClass(UserIngredientId.class)  // 복합 키 클래스 설정
public class UserIngredientEntity {

    @Id
    @Column(name = "u_ingredientId", nullable = false)
    private String u_ingredientId;

    @Id
    @Column(name = "fridgeId", insertable = false, updatable = false, nullable = false)
    private String fridgeId;

    @Id
    @Column(name = "userId", insertable = false, updatable = false, nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "fridgeId", referencedColumnName = "fridgeId", nullable = false),
            @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    })
    private FridgeEntity fridge;  // 복합 키 외래 키 설정

    @Column(name = "u_ingredientName", nullable = false)
    private String u_ingredientName;

    @Column(name = "u_ingredientIconPath")
    private String u_ingredientIconPath;

    @Enumerated(EnumType.STRING)
    @Column(name = "u_ingredienDateType")
    private UserIngredientDTO.DateType u_ingredienDateType;

    @Column(name = "u_ingredientDate")
    private LocalDate u_ingredientDate;

    @Column(name = "u_ingredientAmount")
    private BigDecimal u_ingredientAmount;

    @Column(name = "u_ingredientUnit")
    private String u_ingredientUnit;

    @Column(name = "u_ingredientStorage", nullable = false)
    private String u_ingredientStorage;

    public static UserIngredientEntity toUserIngredientEntity(UserIngredientDTO userIngredientDTO, FridgeEntity fridgeEntity) {
        UserIngredientEntity userIngredientEntity = new UserIngredientEntity();
        userIngredientEntity.setU_ingredientId(userIngredientDTO.getU_ingredientId());
        userIngredientEntity.setFridge(fridgeEntity); // FridgeEntity를 설정
        userIngredientEntity.setU_ingredientName(userIngredientDTO.getU_ingredientName());
        userIngredientEntity.setU_ingredientIconPath(userIngredientDTO.getU_ingredientIconPath());
        userIngredientEntity.setU_ingredienDateType(userIngredientDTO.getU_ingredienDateType());
        userIngredientEntity.setU_ingredientDate(userIngredientDTO.getU_ingredientDate());
        userIngredientEntity.setU_ingredientAmount(userIngredientDTO.getU_ingredientAmount());
        userIngredientEntity.setU_ingredientUnit(userIngredientDTO.getU_ingredientUnit());
        userIngredientEntity.setU_ingredientStorage(userIngredientDTO.getU_ingredientStorage());
        return userIngredientEntity;
    }

    public static UserIngredientEntity toUpdateUserIngredientEntity(UserIngredientDTO userIngredientDTO, FridgeEntity fridgeEntity) {
        UserIngredientEntity userIngredientEntity = new UserIngredientEntity();
        userIngredientEntity.setU_ingredientId(userIngredientDTO.getU_ingredientId());
        userIngredientEntity.setFridge(fridgeEntity); // FridgeEntity를 설정
        userIngredientEntity.setU_ingredientName(userIngredientDTO.getU_ingredientName());
        userIngredientEntity.setU_ingredientIconPath(userIngredientDTO.getU_ingredientIconPath());
        userIngredientEntity.setU_ingredienDateType(userIngredientDTO.getU_ingredienDateType());
        userIngredientEntity.setU_ingredientDate(userIngredientDTO.getU_ingredientDate());
        userIngredientEntity.setU_ingredientAmount(userIngredientDTO.getU_ingredientAmount());
        userIngredientEntity.setU_ingredientUnit(userIngredientDTO.getU_ingredientUnit());
        userIngredientEntity.setU_ingredientStorage(userIngredientDTO.getU_ingredientStorage());
        return userIngredientEntity;
    }
}
