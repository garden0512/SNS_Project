package com.demo.demoweb.dto;

import com.demo.demoweb.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userEmail;

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserPassword(userEntity.getUserPassword());
        userDTO.setUserEmail(userEntity.getUserEmail());

        return userDTO;
    }
}
