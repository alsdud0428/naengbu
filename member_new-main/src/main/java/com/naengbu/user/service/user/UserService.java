package com.naengbu.user.service.user;

import com.naengbu.user.dto.user.UserDTO;
import com.naengbu.user.entity.user.UserEntity;
import com.naengbu.user.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void save(UserDTO userDTO) {
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
        // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
    }

    public UserDTO login(UserDTO userDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<UserEntity> byUserId = userRepository.findByUserId(String.valueOf(userDTO.getUserId()));
        if (byUserId.isPresent()) {
            // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            UserEntity userEntity = byUserId.get();
            if (userEntity.getUserPw().equals(userDTO.getUserPw())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                UserDTO dto = UserDTO.toUserDTO(userEntity);
                return dto;
            } else {
                // 비밀번호 불일치(로그인실패)
                return null;
            }
        } else {
            // 조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }


}