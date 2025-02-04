package com.arifrhm.warehouse.service.dataaccess.user.adapter;

import com.arifrhm.dataaccess.user.repository.UserJpaRepository;
import com.arifrhm.domain.valueobject.UserId;
import com.arifrhm.warehouse.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.arifrhm.warehouse.service.domain.entity.User;
import com.arifrhm.warehouse.service.domain.ports.output.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserDataAccessMapper userDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @PostConstruct
    public void init() {
        System.out.println("UserRepositoryImpl bean initialized.");
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
