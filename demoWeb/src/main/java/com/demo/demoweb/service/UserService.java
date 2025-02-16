package com.demo.demoweb.service;

import com.demo.demoweb.dto.UserDTO;
import com.demo.demoweb.entity.UserEntity;
import com.demo.demoweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO login(UserDTO userDTO) {
        Optional<UserEntity> byUserEmail = userRepository.findByUserEmail(userDTO.getUserEmail());
        if(byUserEmail.isPresent()) {
            UserEntity userEntity = byUserEmail.get();
            if(userEntity.getUserPassword().equals(userDTO.getUserPassword())) {
                UserDTO dto = UserDTO.toUserDTO(userEntity);
                return dto;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public List<UserDTO> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity userEntity : userEntityList) {
            userDTOList.add(UserDTO.toUserDTO(userEntity));
        }
        return userDTOList;
    }

    public UserDTO findByUserId(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if(optionalUserEntity.isPresent()) {
            return UserDTO.toUserDTO(optionalUserEntity.get());
        }else{
            return null;
        }
    }

    public void deleteByUserId(Long userId) {
        userRepository.deleteById(userId);
    }
}
