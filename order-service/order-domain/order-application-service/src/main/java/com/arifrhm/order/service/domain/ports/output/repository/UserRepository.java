package com.arifrhm.order.service.domain.ports.output.repository;

import com.arifrhm.domain.valueobject.UserId;
import com.arifrhm.order.service.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(UserId userId);

    User save(User user);

}
