package com.arifrhm.warehouse.service.dataaccess.user.mapper;

import com.arifrhm.dataaccess.user.entity.UserEntity;
import com.arifrhm.domain.valueobject.UserId;
import com.arifrhm.warehouse.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {

    public UserEntity userToUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId().getValue())
                .email(user.getEmail())
                .name(user.getName())
                .role(user.getRole())
                .isActive(user.isActive())
                .token(user.getToken())
                .build();
    }

    public  User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .userId(new UserId(userEntity.getId()))
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .role(userEntity.getRole())
                .isActive(userEntity.getIsActive())
                .token(userEntity.getToken())
                .build();
    }

}
