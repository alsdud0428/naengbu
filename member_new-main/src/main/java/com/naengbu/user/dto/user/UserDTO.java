package com.naengbu.user.dto.user;

import com.naengbu.user.entity.user.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String userState;

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUserPw(userEntity.getUserPw());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserState(userEntity.getUserState());
        return userDTO;
    }
}
