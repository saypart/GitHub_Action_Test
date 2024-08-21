package com.nemocompany.onegomanna.database.repository.user;

import com.nemocompany.onegomanna.database.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOptionalUserByPhoneNumber(String phoneNumber);
}
