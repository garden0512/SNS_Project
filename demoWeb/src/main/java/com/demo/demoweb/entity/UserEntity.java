package com.demo.demoweb.entity;

import com.demo.demoweb.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="user_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String userEmail;
    @Column
    private String userName;
    @Column
    private String userPassword;

    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserPassword(userDTO.getUserPassword());
        return userEntity;
    }
}
