package com.naengbu.user.repository.ingredient;

import com.naengbu.user.entity.ingredient.UserIngredientEntity;
import com.naengbu.user.entity.ingredient.UserIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIngredientRepository extends JpaRepository<UserIngredientEntity, UserIngredientId> {

}
