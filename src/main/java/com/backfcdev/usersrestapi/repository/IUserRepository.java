package com.backfcdev.usersrestapi.repository;

import com.backfcdev.usersrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
