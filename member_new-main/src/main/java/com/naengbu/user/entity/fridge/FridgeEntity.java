package com.naengbu.user.entity.fridge;

import com.naengbu.user.dto.fridge.FridgeDTO;
import com.naengbu.user.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "fridge")
@IdClass(FridgeId.class)  // 복합 키 클래스 설정
public class FridgeEntity {

    @Id
    @Column(name = "fridgeId", nullable = false)
    private String fridgeId;

    @Id
    @Column(name = "userId" ,nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)  // 외래 키 설정
    private UserEntity user;

    // DTO를 Entity로 변환하는 메서드
    public static FridgeEntity toEntity(FridgeDTO fridgeDTO, UserEntity user) {
        FridgeEntity fridgeEntity = new FridgeEntity();
        fridgeEntity.setFridgeId(fridgeDTO.getFridgeId());
        fridgeEntity.setUser(user);
        fridgeEntity.setUserId(user.getUserId());
        return fridgeEntity;
    }

    // 업데이트 시 DTO를 Entity로 변환하는 메서드
    public static FridgeEntity toUpdateEntity(FridgeDTO fridgeDTO, UserEntity user) {
        FridgeEntity fridgeEntity = new FridgeEntity();
        fridgeEntity.setFridgeId(fridgeDTO.getFridgeId());
        fridgeEntity.setUser(user);
        fridgeEntity.setUserId(user.getUserId());
        return fridgeEntity;
    }
}
