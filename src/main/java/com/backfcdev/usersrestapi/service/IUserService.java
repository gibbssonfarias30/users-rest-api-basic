package com.backfcdev.usersrestapi.service;

import com.backfcdev.usersrestapi.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User save(User user);
    User findById(long id);
    User update(long id, User user);
    long deleteById(long id);

}
