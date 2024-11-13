package com.naengbu.user.entity.user;

import com.naengbu.user.dto.user.UserDTO;
import com.naengbu.user.entity.recipe.SaveRecipeEntity;
import com.naengbu.user.entity.fridge.FridgeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_table")
public class UserEntity {
    @Id
    @Column(name="userId",nullable = false)
    private String userId;

    @Column(name="userPw", nullable = false)
    private String userPw;

    @Column(name="userName")
    private String userName;

    @Column(name="userState")
    private String userState;

    // FridgeEntity와의 일대일 관계 정의
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FridgeEntity fridge;

    // SaveRecipeEntity와의 일대다 관계 정의
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SaveRecipeEntity> saveRecipes;

    // DTO를 Entity로 변환하는 메서드
    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUserPw(userDTO.getUserPw());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserState(userDTO.getUserState());
        return userEntity;
    }

    public static UserEntity toUpdateUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUserPw(userDTO.getUserPw());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserState(userDTO.getUserState());
        return userEntity;
    }
}
