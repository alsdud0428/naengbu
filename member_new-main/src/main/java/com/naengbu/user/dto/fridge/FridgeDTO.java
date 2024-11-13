package com.naengbu.user.dto.fridge;

import com.naengbu.user.entity.fridge.FridgeEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FridgeDTO {
    private String fridgeId;
    private String userId;

    // static 메소드에서 FridgeEntity를 FridgeDTO로 변환
    public static FridgeDTO toFridgeDTO(FridgeEntity fridgeEntity) {
        FridgeDTO fridgeDTO = new FridgeDTO();
        fridgeDTO.setUserId(fridgeEntity.getUser().getUserId()); // 수정된 부분
        fridgeDTO.setFridgeId(fridgeEntity.getFridgeId());
        return fridgeDTO;
    }
}
