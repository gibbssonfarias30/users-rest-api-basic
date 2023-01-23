package com.backfcdev.usersrestapi.service;

import com.backfcdev.usersrestapi.exception.UserNotFoundException;
import com.backfcdev.usersrestapi.model.User;
import com.backfcdev.usersrestapi.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User update(long id, User user) {
        return userRepository.findById(id)
                .map(updateUser -> {
                    updateUser.setUsername(user.getUsername());
                    updateUser.setName(user.getName());
                    updateUser.setEmail(user.getEmail());
                    return userRepository.save(updateUser);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public long deleteById(long id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return id;
    }
}
