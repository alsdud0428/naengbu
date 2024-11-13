package com.naengbu.user.repository.fridge;

import com.naengbu.user.entity.fridge.FridgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeRepository extends JpaRepository<FridgeEntity, String> {

}
