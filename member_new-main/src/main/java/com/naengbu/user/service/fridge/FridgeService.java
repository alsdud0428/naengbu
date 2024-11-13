package com.naengbu.user.service.fridge;

import com.naengbu.user.entity.fridge.FridgeEntity;
import com.naengbu.user.repository.fridge.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FridgeService {

    @Autowired
    private FridgeRepository fridgeRepository;

    // FridgeEntity를 ID로 조회하는 메서드
    public FridgeEntity getFridgeById(String fridgeId) {
        Optional<FridgeEntity> fridgeEntity = fridgeRepository.findById(fridgeId);
        if (fridgeEntity.isPresent()) {
            return fridgeEntity.get();
        } else {
            throw new RuntimeException("Fridge not found with ID: " + fridgeId);
        }
    }

    // FridgeEntity를 새로 추가하는 메서드
    public FridgeEntity addFridge(FridgeEntity fridgeEntity) {
        return fridgeRepository.save(fridgeEntity);
    }

    // FridgeEntity를 업데이트하는 메서드
    public FridgeEntity updateFridge(FridgeEntity fridgeEntity) {
        return fridgeRepository.save(fridgeEntity);
    }

    // FridgeEntity를 삭제하는 메서드
    public void deleteFridge(String fridgeId) {
        fridgeRepository.deleteById(fridgeId);
    }

    // 추가적인 서비스 메서드들을 정의할 수 있습니다.
}
