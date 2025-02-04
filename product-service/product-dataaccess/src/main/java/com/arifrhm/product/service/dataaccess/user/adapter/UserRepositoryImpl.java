package com.arifrhm.product.service.dataaccess.user.adapter;

import com.arifrhm.dataaccess.user.repository.UserJpaRepository;
import com.arifrhm.domain.valueobject.UserId;
import com.arifrhm.product.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.arifrhm.product.service.domain.entity.User;
import com.arifrhm.product.service.domain.ports.output.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserDataAccessMapper userDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public User save(User user) {
        return userDataAccessMapper.userEntityToUser(userJpaRepository
                .save(userDataAccessMapper.userToUserEntity(user)));
    }

    @Override
    public Optional<User> findById(UserId userId) {
        return userJpaRepository.findById(userId.getValue())
                .map(userDataAccessMapper::userEntityToUser);
    }
}
