package com.naengbu.user.controller.ingredient;

import com.naengbu.user.dto.ingredient.UserIngredientDTO;
import com.naengbu.user.service.ingredient.UserIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserIngredientController {

    @Autowired
    private UserIngredientService userIngredientService;

    @PostMapping("/main")
    public ResponseEntity<UserIngredientDTO> addIngredient(@RequestBody UserIngredientDTO userIngredientDTO) {
        try {
            // 요청 데이터 확인을 위한 디버깅 로그
            System.out.println("Received Ingredient DTO: " + userIngredientDTO);

            // u_ingredientId가 null일 경우에 대한 방어 코드
            if (userIngredientDTO.getU_ingredientId() == null || userIngredientDTO.getU_ingredientId().isEmpty()) {
                System.out.println("Ingredient ID is missing");
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            // 서비스 호출
            UserIngredientDTO addedIngredient = userIngredientService.addIngredient(userIngredientDTO);
            return new ResponseEntity<>(addedIngredient, HttpStatus.CREATED);
        } catch (Exception e) {
            // 에러 로그 출력
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

