package com.naengbu.user.service.ingredient;

import com.naengbu.user.dto.ingredient.UserIngredientDTO;
import com.naengbu.user.entity.ingredient.UserIngredientEntity;
import com.naengbu.user.entity.fridge.FridgeEntity;
import com.naengbu.user.repository.ingredient.UserIngredientRepository;
import com.naengbu.user.service.fridge.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIngredientService {

    @Autowired
    private UserIngredientRepository userIngredientRepository;

    @Autowired
    private FridgeService fridgeService;

    public UserIngredientDTO addIngredient(UserIngredientDTO userIngredientDTO) {
        try {
            // FridgeEntity를 가져오는 로직
            FridgeEntity fridgeEntity = fridgeService.getFridgeById(userIngredientDTO.getFridgeId());
            if (fridgeEntity == null) {
                throw new IllegalArgumentException("Fridge with ID " + userIngredientDTO.getFridgeId() + " not found.");
            }

            // DTO를 Entity로 변환
            UserIngredientEntity userIngredientEntity = UserIngredientEntity.toUserIngredientEntity(userIngredientDTO, fridgeEntity);

            // 로그 추가
            System.out.println("UserIngredientEntity: " + userIngredientEntity);

            // 데이터베이스에 저장
            UserIngredientEntity savedEntity = userIngredientRepository.save(userIngredientEntity);

            // 저장된 엔티티를 DTO로 변환하여 반환
            return UserIngredientDTO.toUserIngredientDTO(savedEntity);
        } catch (Exception e) {
            // 예외를 로그로 남기거나 적절히 처리
            e.printStackTrace();
            throw new RuntimeException("Error while adding ingredient", e);
        }
    }
}
